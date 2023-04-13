package com.kh.spring19.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring19.dto.PocketmonDto;
import com.kh.spring19.repo.PocketmonRepo;

@RestController
@RequestMapping("/pocketmon")
public class PocketmonRestController {
	
	@Autowired
	private PocketmonRepo repo;
	
	@PostMapping("/")
	public void add(@ModelAttribute PocketmonDto dto) {
		repo.insert(dto);
	}
	
	@GetMapping("/")
	public List<PocketmonDto>list(){
		return repo.selectList();
	}
	
	@GetMapping("/{no}")
	public PocketmonDto find(@PathVariable int no) {
		return repo.selectOne(no);
	}
	
	@PutMapping("/")
	public void edit(@ModelAttribute PocketmonDto dto) {
		repo.update(dto);
	}
	
	@DeleteMapping("/{no}")
	public void delete(@PathVariable int no) {
		repo.delete(no);
	}
	
}
