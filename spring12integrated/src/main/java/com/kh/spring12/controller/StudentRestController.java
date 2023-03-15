package com.kh.spring12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.StudentDao;
import com.kh.spring12.dto.StudentDto;

// student데이터를 클라이언트에게 전달하는 컨트롤러
@CrossOrigin(origins= {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/rest/student")
public class StudentRestController {

	@Autowired
	private StudentDao studentDao;
	@GetMapping("/")
	public List<StudentDto>list(){
		return studentDao.selectList();	// jackson-databind 가 자동으로 JSON으로...
	}
}
