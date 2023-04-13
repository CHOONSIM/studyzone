package com.kh.springhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.dto.SubjectDto;
import com.kh.springhome.repo.SubjectRepository;

@CrossOrigin(origins= {"http://127.0.0.1:5500/"})
@RestController
@RequestMapping("/rest/subject")
public class SubjectRestController {
	
//	@Autowired
//	private SubjectDao subjectDao;
	@Autowired
	private SubjectRepository subjectRepo;
	
	@GetMapping("/")
	public List<SubjectDto>list(){
		return subjectRepo.selectList();
	}
//	@GetMapping("/{no}")
//	@PostMapping("/")
//	@PutMapping("/")
//	@DeleteMapping("/{no}")
}
