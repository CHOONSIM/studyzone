/**
 * 확인 메세지 출력 후 이동하는 링크 구현
 * 
 * 만든이 : ###
 */

//      목표 : .confirm-link를 누르면 확인창 출력 후 확인 클릭 시 이동(취소 시 차단)
window.addEventListener("load",function(){

    var confirmLinkList = document.querySelectorAll(".confirm-link");

    for(var i=0; i < confirmLinkList.length; i++){
        confirmLinkList[i].addEventListener("click",function(evt){

//                  안내메시지 설정
            var text = this.dataset.msg || "이동하시겠습니까?"
/*                  var text;
            if(!thi.dataset.msg){
                text="이동하시겠습니까?"
            }
            else { 
                text = this.dataset.msg;
            }
*/
                
            });
            var choice = window.confirm("이동하시겠습니까?");
            if(choice == false){
                evt.preventDefault();
            }
    }
});