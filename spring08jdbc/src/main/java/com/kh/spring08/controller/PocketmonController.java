package com.kh.spring08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring08.dao.PocketmonDao;
import com.kh.spring08.dto.PocketmonDto;

//	목표 : Pocketmon 테이블에 대한 CRUD작업을 수행하는 컨트롤러 구현
@Controller
public class PocketmonController {
	
//	아래와 같은 코드는 더이상 사용하지 않는다(스프링을 거치지 않고 객체 생성)
//	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
//	이미 스프링에 생성되어 등록된 요소(spring bean)를 달라고 부탁
//	만약 등록되지 않은 요소를 달라고 했다면 오류
//	내가 만든 도구들도 등록만 되어있다면 주세요(DI, Dependency Injection, 의존성 주입)가능
//	Spring 두번째 특징 (DI, Dependency Injection, 의존성 주입)
	
	
	@Autowired
	private PocketmonDao dao;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute PocketmonDto dto) {
		
		dao.insert(dto);
		
		return "등록 완료!!";
	}
	
	
	//	목록
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
}
