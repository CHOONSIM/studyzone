package com.kh.spring09.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring09.subject.dao.SubjectDao;
import com.kh.spring09.subject.dto.SubjectDto;

@Controller
public class SubjectController {
	
//		등록
	@Autowired
	private SubjectDao dao;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute SubjectDto dto) {
		dao.insert(dto);
		return"등록완료";
	}
	
//		목록검색
	@RequestMapping("/list")
	@ResponseBody
	public String listandsearch(
			@RequestParam(required = false, defaultValue = "name")String column,
			@RequestParam(required = false, defaultValue = "")String keyword) {
		boolean search = !keyword.equals("");
		
		List<SubjectDto>list;
		if(search) 
			list = dao.selectList(column, keyword);
		else
			list = dao.selectList();
		
		StringBuffer buffer = new StringBuffer();
		for(SubjectDto dto : list) {
			buffer.append(dto.toString());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
//		상세
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int no) {
		SubjectDto dto = dao.selectOne(no);
		if(dto==null) 
			return"자료없음";
		else
			return dto.toString();
	}
	
//		수정
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(@ModelAttribute SubjectDto dto) {
		boolean done = dao.update(dto);
		if(done)
			return"변경작업 완료";
		else
			return"변경작업 대상 없음";
		}
		
//		삭제
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int no) {
		boolean done = dao.delete(no);
		if(done)
			return"삭제작업 완료";
		else
			return"삭제작업 대상 없음";
	}
}
