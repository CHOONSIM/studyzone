package com.kh.spring10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	
//	JSP를 사용자에게 전달하려면 컨트롤러에 @ResponseBody가 없어야한다
	
	@RequestMapping("/test01")
//	@ResponseBody			//이 메소드의 결과를 변형없이 사용자에게 전달
	public String test01() {
//		return"test01.jsp의 위치"
		return "/WEB-INF/views/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String test02() {
		return "/WEB-INF/views/test02.jsp";
	}
	
	@RequestMapping("/img01")
	public String img01() {
		return"/WEB-INF/views/img01.jsp";
	}
	
	@RequestMapping("/img02")
	public String img02() {
		return"/WEB-INF/views/img02.jsp";
	}
	
	@RequestMapping("/a01")
	public String a01() {
		return"/WEB-INF/views/a01.jsp";
	}
	
	@RequestMapping("/form01")
	public String form01() {
		return"/WEB-INF/views/form01.jsp";
	}
	
//	pocketmon 등록 폼 페이지
	@RequestMapping("/form02")
	public String form02() {
		return"/WEB-INF/views/form02.jsp";
	}
	
//	pocketmon 검색 폼 페이지
	@RequestMapping("/form03")
	public String form03() {
		return"/WEB-INF/views/form03.jsp";
	}
}
