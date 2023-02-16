package com.kh.spring13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileController {
	
	@GetMapping("/")
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}
}
