package com.kh.spring12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
//	목록
	@GetMapping("/list")
	public String list(Model model,
			@RequestParam(required = false, defaultValue = "name")String column,
			@RequestParam(required = false, defaultValue = "")String keyword) {
//		if(keyword가 비어있다면) {
//			model.addAttribute("list", 목록데이터)
//		}
//		else {
//			model.addAttribute("list", 검색데이터)
//		}
		if(keyword.equals("")) {
			model.addAttribute("list", pocketmonDao.selectList());
		}
		else {
			model.addAttribute("list", pocketmonDao.selectList(column, keyword));
		}
			return "/WEB-INF/views/pocketmon/list.jsp";
	}
	
//	삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int no) {				//처리만해서 화면 필요없음 Model model X
		pocketmonDao.delete(no);
		return"redirect:list";			//상대경로
//		return"ridirect:/pocketmon/list";		//절대경로
	}
	
//	수정(입력+처리)
//	- 수정입력 페이지는 반드시 모든 기존 정보가 작성이 되어 있도로 국현
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int no) {
		model.addAttribute("pocketmonDto",pocketmonDao.selectOne(no));
		return "/WEB-INF/views/pocketmon/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute PocketmonDto pocketmonDto,
			RedirectAttributes attr) {
		pocketmonDao.update(pocketmonDto);
		
//		redirect에 필요한 no 데이터를 추가(주소 뒤에?no=XXX 가 추가됨)
		attr.addAttribute("no", pocketmonDto.getNo());
		return"redirect:detail";
	}
	
	
}
