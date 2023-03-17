// 댓글 처리 자바스크립트 파일

$(function(){
	// 글 번호를 가져온다
	var params = new URLSearchParams(location.search);
	var replyOrigin = params.get("boardNo");
	
	// 댓글 목록 불러오기
	loadList();
	
	// .reply-insert-btn을 누르면 작성한 내용을 등록하는 처리 구현
	$(".reply-insert-btn").click(function(){
		var content = $("[name=replyContent]").val();	// 입력값 불러오기
		if(content.trim().length==0)return;		// 공백입력 방지, 의미없는 값 차단
		
		$.ajax({
			url:"/rest/reply/",
			method:"post",
			data:{
				replyOrigin: replyOrigin,
				replyContent: content
			},
			success:function(response){
				loadList();		// 목록 불러오기
				$("[nmae=replyContent]").val("");		// 입력창 청소
			},
			error:function(){
				alert("통신 오류가 발생 잠시 후 다시 시도하세요.");
			}
		})
	});
	
	// 목록을 불러오는 함수
	function loadList(){
		$(".reply-list").empty();		//대상 영역을 청소
		
		$.ajax({
			url:"/rest/reply/"+replyOrigin,
			method:"get",
			success:function(response){		//response =List<ReplyDto>
//				console.log(response);
				for(var i=0; i < response.length; i++){
					// 템플릿 불러와서 세팅하고 추가하는 코드
					var template = $("#reply-template").html();	// 쳄플릿 불러와서
					var html = $.parseHTML(template);		// 사용할 수 있게 변환하고
					
					$(html).find(".replyWriter").text(response[i].replyWriter);
					$(html).find(".replyContent").text(response[i].replyContent);
					$(html).find(".replyTime").text(response[i].replyTime);
					
					// 작성자 본인의 댓글에는 태그를 생성해서 추가 표시
					// -> boardWriter == response[i].replyWriter
					if(boardWriter == response[i].replyWriter){
						var author = $("<span>").addClass("author ms-10").text("작성자");
						$(html).find(".replyWriter").append(author);
					}
					
					// 내가 쓴 댓글에는 수정/삭제 버튼을 추가 표시
					if(memberId == response[i].replyWriter){
						var editButton= $("<i>").addClass("fa-solid fa-edit ms-20")
																.attr("data-reply-no", response[i].replyNo);
																
						var deleteButton= $("<i>").addClass("fa-solid fa-trash ms-10")
																.attr("data-reply-no", response[i].replyNo)
																.click(deleteReply);
						
						$(html).find(".replyWriter").append(editButton).append(deleteButton);	
					}
					
					$(".reply-list").append(html);		//목록 영역에 추가
				}
			},
			error:function(){
				alert("통신 오류 발생");
			}
		});
	};
	
	function deleteReply(){
		var choice = window.confirm("정말 삭제하시겠습니까? \n 삭제 후 복구는 어렵습니다.")
		if(choice == false)return;
		
		var replyNo = $(this).data("reply-no");
		
		$.ajax({
			url:"/rest/reply/"+replyNo,
			method:"delete",
			success:function(response){
				loadList();
			},
			error:function(){
				alert("통신 오류 발생 \n 잠시 후 다시 실행하세요".)
			}
			
		})
	}
});