package com.kh.spring12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.PocketmonDao;
import com.kh.spring12.dto.PocketmonDto;

// 이 컨트롤러의 목표는 XHR통신에 대해서처리 후 JSON을 반환하는 것
// Q) Spring에서는 JSON을 어떻게 만드는가?
// A) 안만들어도 된다. Jackson-Databind 라이브러리가 자동변환을 해준다. (배열,List)

//CORS를 허용해야 한다면 @CrossOrigin을 추가
//@CrossOrigin(origins = {"*"})		// 전부다 혀용(공공API 만드는 경우
@CrossOrigin(origins = {"http://127.0.0.1:5500/"})		//특정 출처만 허용(host,port)
@RestController
@RequestMapping("/rest/pocketmon")
public class PocketmonRestController {

		@Autowired
		private PocketmonDao pocketmonDao;
		
		@GetMapping("/")
		public List<PocketmonDto> list() {
			return pocketmonDao.selectList();		
	}
		@GetMapping("/{no}")
		public String find(@PathVariable int no) {
			PocketmonDto dto = pocketmonDao.selectOne(no);
			if(dto==null) {	// 없다 -> 사용 가능
				return"NNNNY";
			}
			else {		// 있다 -> 사용 불가
				return"NNNNN";
			}
		}
		
		@PostMapping("/")		// 클라이언트에 넘겨줄 정보가 없으므로 반환형 void
		public void insert(@ModelAttribute PocketmonDto pocketmonDto) {
			pocketmonDao.insert(pocketmonDto);
		}
}
