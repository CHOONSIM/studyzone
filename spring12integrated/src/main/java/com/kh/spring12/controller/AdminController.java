package com.kh.spring12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring12.dao.MemberDao;
import com.kh.spring12.dto.MemberDto;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired			// 의존성 주입 dependancy injection
	private MemberDao memberDao;
	
	@GetMapping("/member/list")
	public String memberList(
		Model model, 
		@RequestParam(required = false, defaultValue = "1")int page,
		@RequestParam(required = false, defaultValue = "10")int size){
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		
//		화면에서 목록 하단에 숫자 링크(페이지 네비게이터)를 보여주려면..
//		총 몇 페이지가 있는지를 계산
//		계산을 하려면 전체 게시글 몇개인지 파악해야함
//		- select count(*) from member;
		int totalCount = memberDao.selectCount();
		model.addAttribute("totalCount", totalCount);
		
		int totalPage = (totalCount + size-1)/10;
		model.addAttribute("totalPage",totalPage);
		
		List<MemberDto> list = memberDao.selectListPaging(page, size);
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/member/list.jsp";
	}
	
}
