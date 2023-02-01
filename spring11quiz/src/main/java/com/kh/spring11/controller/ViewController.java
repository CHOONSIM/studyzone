package com.kh.spring11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	
//	student 등록
	@RequestMapping("/form01")
	public String form01() {
		return "/WEB-INF/views/form01.jsp";
	}
	
//	student 목록,검색,상세
	@RequestMapping("/form02")
	public String form02() {
		return "/WEB-INF/views/form02.jsp";
	}
	
//	student 수정
	@RequestMapping("/form03")
	public String form03() {
		return "/WEB-INF/views/form03.jsp";
	}
	
//	student 삭제
	@RequestMapping("/form04")
	public String form04() {
		return "/WEB-INF/views/form04.jsp";
	}

//	subject 등록
	@RequestMapping("/form05")
	public String form05() {
		return "/WEB-INF/views/form05.jsp";
	}
	
//	subject 목록검색상세
	@RequestMapping("/form06")
	public String form06() {
		return "/WEB-INF/views/form06.jsp";
	}
	
//	subject 수정
	@RequestMapping("/form07")
	public String form07() {
		return "/WEB-INF/views/form07.jsp";
	}
	
//	subject 삭제
	@RequestMapping("/form08")
	public String form08() {
		return "/WEB-INF/views/form08.jsp";
	}


}
