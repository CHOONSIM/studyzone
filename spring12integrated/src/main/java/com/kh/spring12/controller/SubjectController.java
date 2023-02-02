package com.kh.spring12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring12.dao.SubjectDao;
import com.kh.spring12.dto.SubjectDto;

@Controller

//	이 부분은 무조건 @RequestMapping으로 작성
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectDao subjectDao;
	
	
//	Tip : 처리방식이 다르면 주소가 같아도 된다(메소드 오버로딩과 비슷)
//	등록페이지로 못들어가게 아예 insert를 통일
	@GetMapping("/insert")
	public String insertInput() {
		return "/WEB-INF/views/subject/insert.jsp";
	}
	
	@PostMapping("/insert")
	public String insertProcess(@ModelAttribute SubjectDto subjectDto) {
		subjectDao.insert(subjectDto);
		return "redirect:insertFinish";
	}
	
	@GetMapping("/insertFinish")
	public String insertFinish() {
		return"/WEB-INF/views/subject/insertFinish.jsp";
	}

}
