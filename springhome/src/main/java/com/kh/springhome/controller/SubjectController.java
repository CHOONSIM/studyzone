package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.springhome.dao.SubjectDao;
import com.kh.springhome.dto.SubjectDto;
import com.kh.springhome.repo.SubjectRepository;

@Controller

//	이 부분은 무조건 @RequestMapping으로 작성
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectDao subjectDao;
	
	// 아래와 같이 주입 설정을 하면 자동으로 상속된 클래스 중 등록된 객체가 주입
	// (주의) 하나만 등록되어 있어야 함
	@Autowired
	private SubjectRepository subjectRepo;
	
	
//	Tip : 처리방식이 다르면 주소가 같아도 된다(메소드 오버로딩과 비슷)
//	등록페이지로 못들어가게 아예 insert를 통일
	@GetMapping("/insert")
	public String insertInput() {
		return "/WEB-INF/views/subject/insert.jsp";
	}
	
	@PostMapping("/insert")
	public String insertProcess(@ModelAttribute SubjectDto subjectDto) {
		subjectRepo.insert(subjectDto);
		return "redirect:insertFinish";
	}
	
	@GetMapping("/insertFinish")
	public String insertFinish() {
		return"/WEB-INF/views/subject/insertFinish.jsp";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int no ) {
		SubjectDto subjectDto = subjectRepo.selectOne(no);
		model.addAttribute("subjectDto", subjectDto);
		return"/WEB-INF/views/subject/detail.jsp";
	}
	
	@GetMapping("/list")
	public String list(Model model,
			@RequestParam(required = false, defaultValue = "") String column,
			@RequestParam(required = false, defaultValue = "") String keyword) {
		boolean search = !column.equals("") && !keyword.equals("");
		if(search) {
			model.addAttribute("keyword", keyword);
			model.addAttribute("mode", "검색");
			model.addAttribute("list", subjectDao.selectList(column, keyword));
		}
		else {
			model.addAttribute("mode", "목록");
			model.addAttribute("list", subjectRepo.selectList());
		}
		return "/WEB-INF/views/subject/list.jsp";
	}
	
//	리다이렉트 사용시 데이터를 첨부해야 하는 경우
//	- 스프링에서 RedirectAttributes 라는 도구를 제공
//	- Model과 사용법이 동일
	
	@GetMapping("/delete")
	public String delete(
				@RequestParam int no,
				@RequestParam (required = false, defaultValue = "")String keyword,
				RedirectAttributes attr) {
		subjectRepo.delete(no);
		if(keyword.equals("")) {
			
			return "redirect:list";
		}
		else {
			return"redirect:'ist";
		}
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int no) {
		SubjectDto subjectDto = subjectRepo.selectOne(no);
		model.addAttribute("subjectDto", subjectDto);
		return "/WEB-INF/views/subject/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute SubjectDto subjectDto,
			RedirectAttributes attr) {
		subjectRepo.update(subjectDto);
		
		//redirect에 필요한 no 데이터를 추가 (주소 뒤에 ?no=xxx 가 추가됨)
		attr.addAttribute("no", subjectDto.getNo());
		return "redirect:detail";		
	}
	
	
}
