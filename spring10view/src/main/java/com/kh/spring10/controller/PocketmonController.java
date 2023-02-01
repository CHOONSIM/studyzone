package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring10.dao.PocketmonDao;
import com.kh.spring10.dto.PocketmonDto;

//	목표 : Pocketmon 테이블에 대한 CRUD작업을 수행하는 컨트롤러 구현
@Controller
@RequestMapping("/pocketmon")
public class PocketmonController {
	
//	아래와 같은 코드는 더이상 사용하지 않는다(스프링을 거치지 않고 객체 생성)
//	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
//	이미 스프링에 생성되어 등록된 요소(spring bean)를 달라고 부탁
//	만약 등록되지 않은 요소를 달라고 했다면 오류
//	내가 만든 도구들도 등록만 되어있다면 주세요(DI, Dependency Injection, 의존성 주입)가능
//	Spring 두번째 특징 (DI, Dependency Injection, 의존성 주입)
	
	
//		등록
//	http://localhost:8080/insert?no=1&name=테스트&type=테스트
	@Autowired
	private PocketmonDao dao;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute PocketmonDto dto) {
		
		dao.insert(dto);
		
		return "등록 완료!!";
	}
	
	
//		목록
	@RequestMapping("/list")
	@ResponseBody
	public String list() {
		List<PocketmonDto> list = dao.selectList();
		
		StringBuffer buffer = new StringBuffer();
		for(PocketmonDto dto : list) {
			buffer.append(dto.toString());
			buffer.append("<br>");				//줄바꿈				
		
		}
		return buffer.toString();
	}
	
//		검색페이지
	@RequestMapping("/serch")
	@ResponseBody
	public String search(@RequestParam String column, 
								@RequestParam String keyword) {
		List<PocketmonDto> list = dao.selectList(column, keyword);
		
		StringBuffer buffer = new StringBuffer();
		for(PocketmonDto dto : list) {
			buffer.append(dto.toString());
			buffer.append("<br>");				//줄바꿈				
		
		}
		return buffer.toString();
	}
	
	
//		목록&검색 통합페이지
//		http://localhost:8080/all-in-one?column=name&keyword=이리
	@RequestMapping("/all-in-one")		//주소에는 대시(-) 사용가능
	@ResponseBody
	public String allInOne(
			@RequestParam(required = false, defaultValue = "name") String column,
			@RequestParam(required = false, defaultValue = "") String keyword) {
			boolean search = !keyword.equals("");
			
			List<PocketmonDto> list;
			if(search) {
				list = dao.selectList(column, keyword);
			}
			else {
				list = dao.selectList();
			}
			StringBuffer buffer = new StringBuffer();
			for(PocketmonDto dto : list) {
				buffer.append(dto.toString());
				buffer.append("<br>");				//줄바꿈				
			
			}
			return buffer.toString();
	}
	
	
//		상세페이지
//		http://localhost:8080/detail?no=1
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int no) {			//Primary Key = no
		PocketmonDto dto = dao.selectOne(no);
		
		if(dto==null) {
			return "없음";
		}
		else {
			return dto.toString();
		}
	}
	
	
//		수정페이지 
//		http://localhost:8080/edit?no=1&name=테스트&type=테스트
	@RequestMapping("/edit")	//SOA : Service Oriented Architecture 기능고려하여 이름
	@ResponseBody
	public String edit(@ModelAttribute PocketmonDto dto) {
		boolean sucess = dao.update(dto);
		if(sucess) 
			return "변경완료";
		else
			return "대상없음";
	}
	
	
//	삭제페이지
//	http://localhost:8080/delete?no=1
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int no) {
		boolean sucess = dao.delete(no);
		
		if(sucess) 
			return "삭제완료";
		else
			return "대상없음";
	}
}
