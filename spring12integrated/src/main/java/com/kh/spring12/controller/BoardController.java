package com.kh.spring12.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring12.dao.BoardDao;
import com.kh.spring12.dto.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
//	게시글 리스트
	@GetMapping("/list")
	public String boardList(Model model,
			@RequestParam(required = false, defaultValue = "name")String column,
			@RequestParam(required = false, defaultValue = "")String keyword) {
		if(keyword.equals("")) {
			model.addAttribute("list", boardDao.selectList());
		}
		else {//키워드가 있다면 -> 검색
			model.addAttribute("column", column);
			model.addAttribute("keyword", keyword);
			model.addAttribute("list", boardDao.selectList(column, keyword));
		}
			return "/WEB-INF/views/board/list.jsp";
	}
//	public String list(
//			Model model,
//			@RequestParam(required = false, defaultValue = "1")int page,
//			@RequestParam(required = false, defaultValue = "0")int size) {
//			model.addAttribute("page",page);
//			model.addAttribute("size", size);
//			
//			int totalCount = boardDao.selectCount();
//			model.addAttribute("totalCount", totalCount);
//			
//			int totalPage = (totalCount + size-1)/size;
//			model.addAttribute("totalPage", totalPage);
//			
//			List<BoardDto>list = boardDao.selectListPaging(page,size);
//			model.addAttribute("list", list);
//			return "/WEB-INF/views/board/list.jsp";
//	}
	@GetMapping("/detail")
	public String detail(@RequestParam int boardNo, 
						Model model, HttpSession session) {
		//사용자가 작성자인지 판정 후 JSP로 전달
		BoardDto boardDto = boardDao.selectOne(boardNo);
		String memberId = (String) session.getAttribute("memberId");
		
		boolean owner = boardDto.getBoardWriter() != null 
				&& boardDto.getBoardWriter().equals(memberId);
		model.addAttribute("owner", owner);
		
		//사용자가 관리자인지 판정 후 JSP로 전달
		String memberLevel = (String) session.getAttribute("memberLevel");
		boolean admin = memberLevel != null && memberLevel.equals("관리자");
		model.addAttribute("admin", admin);
		
		//조회수 증가
		if(!owner) {//내가 작성한 글이 아니라면(시나리오 1번)
			
			//시나리오 2번 진행
			Set<Integer> memory = (Set<Integer>) session.getAttribute("memory");
			if(memory == null) {
				memory = new HashSet<>();
			}
			
			if(!memory.contains(boardNo)) {//읽은 적이 없는가(기억에 없는가)
				boardDao.updateReadcount(boardNo);
				boardDto.setBoardRead(boardDto.getBoardRead()+1);//DTO 조회수 1증가
				memory.add(boardNo);//저장소에 추가(기억에 추가)
			}
			//System.out.println("memory = " + memory);
			session.setAttribute("memory", memory);//저장소 갱신
			
		}
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/detail.jsp";
	}
	
	//경로 변수 방식의 상세조회
	//- 매핑 주소에 중괄호를 적고 변수명을 작성하면 스프링에서 수신해준다
	//- 매개변수에 @PathVariable 형태로 주소에 작성한 변수명을 선언한다
	//장점
	//- 주소의 가독성 증가
	//- 전송방식과 무관하게 사용이 가능
	//- 정규표현식 검사가 가능
	//단점
	//- 엔드포인트(endpoint)가 달라져서 상대경로를 쓰기 불편함
	//- 보내는 데이터 양이 많아질 수록 가독성이 오히려 안좋아진다
	//- 경로 변수 방식을 지원하지 않는 라이브러리들이 있음(수작업)
	@GetMapping("/detail/{boardNo}")
	public String detail2(@PathVariable int boardNo, Model model) {
		model.addAttribute("boardDto", boardDao.selectOne(boardNo));
		return "/WEB-INF/views/board/detail.jsp";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@PostMapping("/write")
	public String write(
			@ModelAttribute BoardDto boardDto,//3개(말머리,제목,내용)
			HttpSession session, RedirectAttributes attr
			) {
		int boardNo = boardDao.sequence();
		String memberId = (String)session.getAttribute("memberId");
		
		boardDto.setBoardNo(boardNo);
		boardDto.setBoardWriter(memberId);
		
		boardDao.insert(boardDto);
		
		attr.addAttribute("boardNo", boardNo);
		return "redirect:detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boardDao.delete(boardNo);
//		return "redirect:list";//상대경로
		return "redirect:/board/list";//절대경로
	}
	
	@GetMapping("/delete/{boardNo}")
	public String delete2(@PathVariable int boardNo) {
		boardDao.delete(boardNo);
//		return "redirect:../list";//상대경로
		return "redirect:/board/list";//절대경로
	}
	
//	할일 : 
//	- 준비 : 글번호
//	- 처리 : 글정보 조회
//	- 결과 : 화면에 조회한 데이터 전달
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		model.addAttribute("boardDto", boardDao.selectOne(boardNo));
		return "/WEB-INF/views/board/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto, 
											RedirectAttributes attr) {
		boardDao.update(boardDto);
		attr.addAttribute("boardNo", boardDto.getBoardNo());
		return "redirect:detail";
	}

}
