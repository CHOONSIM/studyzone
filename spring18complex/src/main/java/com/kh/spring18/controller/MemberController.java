package com.kh.spring18.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kh.spring18.dto.MemberDto;
import com.kh.spring18.vo.MemberComplexSearchVO;

@Controller
public class MemberController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("/")
	public String home(
			@ModelAttribute("vo") MemberComplexSearchVO vo,
			Model model) {
		List<MemberDto> list = sqlSession.selectList("member.complexSearch", vo);
		model.addAttribute("list",list);
		return"/WEB-INF/views/home.jsp";
	}
}
