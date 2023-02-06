package com.kh.spring12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring12.dao.MemberDao;
import com.kh.spring12.dto.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
//	회원가입
	
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:joinFinish";
	}
	
	
	@GetMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
	
//	로그인
	
	@GetMapping("/login")
	public String login() {
		return"/WEB-INF/views/member/login.jsp";
	}
	
	@PostMapping("/login")
	public String login(
			@ModelAttribute MemberDto userDto,
			RedirectAttributes attr) {
//		로그인검사 : 단일 조회 후 비밀번호 일치 비교
		MemberDto findDto = memberDao.selectOne(userDto.getMemberId());
		
//		존재하지 않는 아이디라면 -> 오류처리
		if(findDto == null) {		
			attr.addAttribute("mode","erroe");
			return"redirect:login";		// redirect도 GET방식 요청을 발생
			}		
//		비밀번호가 일치하지 않는다면 -> 오류처리
		if(!userDto.getMemberPw().equals(findDto.getMemberPw())) {	
			attr.addAttribute("mode","error");
			return"redirect:login";
		}
		
//		모두 통과한 경우만 남음
			return"redirect:/";		//메인페이지
	}
}
