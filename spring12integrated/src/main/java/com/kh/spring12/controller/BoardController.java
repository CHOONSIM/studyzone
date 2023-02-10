package com.kh.spring12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring12.dao.BoardDao;
import com.kh.spring12.dto.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
//	게시글 리스트
	@GetMapping("/list")
	public String boardList(Model model,
			@RequestParam(required = false, defaultValue = "name")String column,
			@RequestParam(required = false, defaultValue = "")String keyword) {
		if(keyword.equals("")) {
			model.addAttribute("list", boardDao.selectList());
		}
		else {
			model.addAttribute("list", boardDao.selectList(column, keyword));
		}
			return "/WEB-INF/views/board/list.jsp";
	}
//	public String list(
//			Model model,
//			@RequestParam(required = false, defaultValue = "1")int page,
//			@RequestParam(required = false, defaultValue = "0")int size) {
//			model.addAttribute("page",page);
//			model.addAttribute("size", size);
//			
//			int totalCount = boardDao.selectCount();
//			model.addAttribute("totalCount", totalCount);
//			
//			int totalPage = (totalCount + size-1)/size;
//			model.addAttribute("totalPage", totalPage);
//			
//			List<BoardDto>list = boardDao.selectListPaging(page,size);
//			model.addAttribute("list", list);
//			return "/WEB-INF/views/board/list.jsp";
//	}

}
