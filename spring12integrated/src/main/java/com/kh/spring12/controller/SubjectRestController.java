package com.kh.spring12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.SubjectDao;
import com.kh.spring12.dto.SubjectDto;

@CrossOrigin(origins= {"http://127.0.0.1:5500/"})
@RestController
@RequestMapping("/rest/subject")
public class SubjectRestController {
	
	@Autowired
	private SubjectDao subjectDao;
	@GetMapping("/")
	public List<SubjectDto>list(){
		return subjectDao.selectList();
	}
//	@GetMapping("/{no}")
//	@PostMapping("/")
//	@PutMapping("/")
//	@DeleteMapping("/{no}")
}
