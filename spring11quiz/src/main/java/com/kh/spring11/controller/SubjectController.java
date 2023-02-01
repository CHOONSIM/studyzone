package com.kh.spring11.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring11.dao.SubjectDao;
import com.kh.spring11.dto.SubjectDto;


//컨트롤러에는 공용 주소를 부여할 수 있다
@Controller
@RequestMapping("/subject")
public class SubjectController {
//	@RequestMapping("/insert")
//	@RequestMapping("/list")
//	@RequestMapping("/detail")
//	@RequestMapping("/edit")
//	@RequestMapping("/delete")
	
//		등록
	@Autowired
	private SubjectDao dao;
	
	
//	@RequestMapping("/insert")
//	@ResponseBody
//	public String insert(@ModelAttribute SubjectDto dto) {
//		dao.insert(dto);
//		return"등록완료";		// -> 목록으로 이동 
//	}
	
//	등록이 완료된 이후에 텍스트 메세지가 아니라 다른곳으로 보내고 싶다면
//	사용자에게 재접속을 요청하도록 처리할 수 있다(Redirect, 리다이렉트)
	@RequestMapping("/insert")
	public String insert(@ModelAttribute SubjectDto dto) {
		dao.insert(dto);
//		return "redirect:list";					//상대경로
		return"redirect:/subject/listandsearch";		//절대경로	
	}
	
//		목록검색
	@RequestMapping("/listandsearch")
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
		
		return done  ? "변경작업 완료" : "변견작업 대상 없음"; 		//삼항연산자 - 조건 ? if : else
//		if(done)
//			return"변경작업 완료";
//		else
//			return"변경작업 대상 없음";
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
