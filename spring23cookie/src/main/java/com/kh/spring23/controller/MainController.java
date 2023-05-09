package com.kh.spring23.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//visit라는 이름의 쿠키가 있는지 확인
	//[1] 없다면 처음온 것으로 간주
	//[2] 있다면 시간차를 구하여 첨부(1주일 넘었는지 판정하여 첨부)
	
	//구현 방법은 (1) JAVA EE사용(HttpServletRequest,HttpServletResponse), (2)Spring 사용 두가지가 존재
	@GetMapping("/")
	public String home(
			@CookieValue(required = false) String visit,
			Model model) {
		if(visit == null) {	//최초방문
			model.addAttribute("first", true);			
		}
		else {
			model.addAttribute("first", false);		
			long current = System.currentTimeMillis();
			long before = Long.parseLong(visit);
			long diff = current - before;
			model.addAttribute("diff", diff);					
		}
		return "home";
	}
	
	//쿠키 생성
	// [1] HttpCookie 클래스의 객체를 생성
	// [2] (선택) 생성한 쿠키 객체에 만료시간을 설정
	// [3] HttpServletResponse 응답객체에 쿠키를 첨부하여 사용자에게 발송
	@GetMapping("/create")
	public String create(HttpServletResponse response) {
		//쿠키엔 띄어쓰기 불가 
//		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Cookie cookie = new Cookie("visit", String.valueOf(System.currentTimeMillis()));	// [1]
		// cookie.setMaxAge(10);	// [2] 10초
		cookie.setMaxAge(4*7*24*60*60);	//[2] 4주
//		cookie.setHttpOnly(true);	// 자바스크립트에서 접근불가(XSS 하이재킹 방지)
		response.addCookie(cookie);	// [3]
		
		return "redirect:/";
	}
	
	// 쿠키는 삭제 명령이 없다
	@GetMapping("/delete")
	public String delete(HttpServletResponse response) {
		Cookie cookie = new Cookie("visit", String.valueOf(System.currentTimeMillis()));	// [1]
		 cookie.setMaxAge(0);	// [2] 0초뒤 (삭제와 동일한 의미)
		response.addCookie(cookie);	// [3]
		
		return "redirect:/";
	}
	
	
}
