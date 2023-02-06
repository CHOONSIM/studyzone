package com.kh.spring12.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
			RedirectAttributes attr, HttpSession session) {
//		로그인검사 : 단일 조회 후 비밀번호 일치 비교
		MemberDto findDto = memberDao.selectOne(userDto.getMemberId());
		
//		존재하지 않는 아이디라면 -> 오류처리
		if(findDto == null) {		
			attr.addAttribute("mode","error");
			return"redirect:login";		// redirect도 GET방식 요청을 발생
			}		
//		비밀번호가 일치하지 않는다면 -> 오류처리
		if(!userDto.getMemberPw().equals(findDto.getMemberPw())) {	
			attr.addAttribute("mode","error");
			return"redirect:login";
		}
		
//		로그인에 성공한 경우라면 이를 기억하기 위해 HttpSession에 정보를 추가
//		- memberId = 회원 아이디
//		- memberLevel = 회원레벨
		session.setAttribute("memberId", findDto.getMemberId());
		session.setAttribute("memberLevel", findDto.getMemberLevel());
		
//		모두 통과한 경우만 남음
			return"redirect:/";		//메인페이지
	}
	
//	로그아웃	-	세션에 저장된 데이터를 삭제하는 작업
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("memberId");
		session.removeAttribute("memberLevel");
		return"redirect:/";
	}
	
//	내정보
//	1. 세션에서 회원 아이디 추출
//	2. 추출한 아이디로 대상의 정보를 상세조회
//	3. 상세조회한 결과를 Model에 첨부
	
	@GetMapping("/mypage")
	public String mypage(
			HttpSession session, Model model) {
		
		String memberId = (String) session.getAttribute("memberId");
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto",memberDto);
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
}
