package com.kh.spring12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring12.dao.PocketmonDao;
import com.kh.spring12.dto.PocketmonDto;

@Controller
@RequestMapping("/pocketmon")
public class PocketmonController {
	
	@Autowired
	private PocketmonDao pocketmonDao;
	
//	@RequestMapping("/insertInput")			//GET, POST 관계없이 모든 방식 처리
//	@RequestMapping(value ="/insertINput", method = RequestMethod.GET)		// GET으로 처리
	@GetMapping("/insertInput") 			// GET 방식만 처리
	public String inserInput() {
		return "/WEB-INF/views/pocketmon/insertInput.jsp";
	}
	
//	@RequestMapping("/insertProcess")
	@PostMapping("/insertProcess")		//POST 방식만 처리
	public String insertProcess(@ModelAttribute PocketmonDto pocketmonDto) {
		pocketmonDao.insert(pocketmonDto);
//		return "redirect:/pocketmon/insertFinish";//절대경로
		return "redirect:insertFinish";					//끝났으니까 다른 곳으로 이동
	}
	
//	@RequestMapping("/insertFinish")
	@GetMapping("/insertFinish")
	public String insertFinish() {
		return"/WEB-INF/views/pocketmon/insertFinish.jsp";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int no) {
		PocketmonDto pocketmonDto = pocketmonDao.selectOne(no);
		model.addAttribute("pocketmonDto",pocketmonDto);
		return"/WEB-INF/views/pocketmon/detail.jsp";
	}
	
	
	
	
	
	
	
	
}
