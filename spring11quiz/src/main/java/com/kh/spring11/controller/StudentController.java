package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring11.dao.StudentDao;
import com.kh.spring11.dto.StudentDto;

@Controller
public class StudentController {
	
//		등록
	@Autowired
	private StudentDao dao;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute StudentDto dto) {
		dao.insert(dto);
		return"등록 완료";
	}
	
//		목록검색
	@RequestMapping("/listandsearch")
	@ResponseBody
	public String listandsearch(
			@RequestParam(required = false, defaultValue = "name")String column,
			@RequestParam(required = false, defaultValue = "")String keyword) {
		boolean search = !keyword.equals("");
		
		List<StudentDto> list;
		if(search)
			list = dao.selectList(column, keyword);
		else
			list = dao.selectList();
		
		StringBuffer buffer = new StringBuffer();
		for(StudentDto dto : list) {
			buffer.append(dto.toString());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
//		상세
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int no) {
		StudentDto dto = dao.selctOne(no);
		if(dto == null)
			return "자료없음";
		else
			return dto.toString();
	}
	
//		수정
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(@ModelAttribute StudentDto dto) {
		boolean done = dao.update(dto);
		if(done) 
			return "변경 작업 완료";
		else
			return "변경 작업 대상 없음";
	}
	
//		삭제
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int no) {
		boolean done = dao.delete(no);
		if(done)
			return"삭제 작업 완료";
		else
			return"삭제 대상 없음";
	}
	
}
