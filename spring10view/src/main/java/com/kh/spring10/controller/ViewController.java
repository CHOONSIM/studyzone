package com.kh.spring10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
}
