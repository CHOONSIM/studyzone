package com.kh.spring11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	
//	student 등록
	@RequestMapping("/formSt01")
	public String formSt01() {
		return "/WEB-INF/views/formSt01.jsp";
	}
	
//	student 목록,검색,상세
	@RequestMapping("/formSt02")
	public String formSt02() {
		return "/WEB-INF/views/formSt02.jsp";
	}
	
//	student 수정
	@RequestMapping("/formSt03")
	public String formSt03() {
		return "/WEB-INF/views/formSt03.jsp";
	}
	
//	student 삭제
	@RequestMapping("/formSt04")
	public String formSt04() {
		return "/WEB-INF/views/formSt04.jsp";
	}

//	subject 등록
	@RequestMapping("/formSt01")
	public String formSu01() {
		return "/WEB-INF/views/formSu01.jsp";
	}
	
//	subject 목록검색상세
	@RequestMapping("/formSu02")
	public String formSu02() {
		return "/WEB-INF/views/formSu02.jsp";
	}
	
//	subject 수정
	@RequestMapping("/formSu03")
	public String formSu03() {
		return "/WEB-INF/views/formSu03.jsp";
	}
	
//	subject 삭제
	@RequestMapping("/formStu04")
	public String formSu04() {
		return "/WEB-INF/views/formSu04.jsp";
	}


}
