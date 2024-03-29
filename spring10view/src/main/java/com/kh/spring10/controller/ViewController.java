package com.kh.spring10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dto.PocketmonDto;

@Controller
@RequestMapping("/view")
public class ViewController {
	
//	JSP를 사용자에게 전달하려면 컨트롤러에 @ResponseBody가 없어야한다
	
	@RequestMapping("/test01")
//	@ResponseBody			//이 메소드의 결과를 변형없이 사용자에게 전달
	public String test01() {
//		return"test01.jsp의 위치"
		return "/WEB-INF/views/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String test02() {
		return "/WEB-INF/views/test02.jsp";
	}
	
	@RequestMapping("/img01")
	public String img01() {
		return"/WEB-INF/views/img01.jsp";
	}
	
	@RequestMapping("/img02")
	public String img02() {
		return"/WEB-INF/views/img02.jsp";
	}
	
	@RequestMapping("/a01")
	public String a01() {
		return"/WEB-INF/views/a01.jsp";
	}
	
	@RequestMapping("/form01")
	public String form01() {
		return"/WEB-INF/views/form01.jsp";
	}
	
//	pocketmon 등록 폼 페이지
	@RequestMapping("/form02")
	public String form02() {
		return"/WEB-INF/views/form02.jsp";
	}
	
//	pocketmon 검색 폼 페이지
	@RequestMapping("/form03")
	public String form03() {
		return"/WEB-INF/views/form03.jsp";
	}
	
	
	/*-----------------------------------------------------------------------------------------------*/
	
//	만약 View(화면)으로 데이터로 전달하고 싶다면?
//	- Spring에서 제고하는 방법 중 Model 클래스를 사용
//	- Model을 매개변수로 선언하면 자동으로 화면까지 전달
//	- 원하는 데이터를 Model에 첨부하면 된다
//	- 데이터 추가는 model.addAttribute("key",value)로 한다
//	- key는 문자열 , value는 아무거나 가능
	
	@GetMapping("/data01")
	public String data01(Model model) {
		model.addAttribute("a", 100);
		model.addAttribute("b", "hello");
		PocketmonDto dto = new PocketmonDto();
		dto.setNo(999);
		dto.setName("아무개요");
		dto.setType("테스트");
		model.addAttribute("monster", dto);
		return"/WEB-INF/views/data01.jsp";
	}
	
	@GetMapping("/data02")
	public String data02(Model model,
		@RequestParam int a, @RequestParam int b) {
		int result = a*b;
		model.addAttribute("result",result);
		return "/WEB-INF/views/data02.jsp";
	}
	
	@GetMapping("/data03")
	public String data03(Model model, @RequestParam double krw) {
		double usd = krw * 0.00082;
		model.addAttribute("usd", usd);
		return"/WEB-INF/views/data03.jsp";
	}
	
	
//	데이터라는 것이 항상 고정적으로 있지는 않다
//	(EX :  상세정보는 PK따라 데이터가 달라짐)
	@GetMapping("/data04")
	public String data04(Model model) {
//		model.addAttribute("message",null);
		model.addAttribute("message", "HELLO JSP");
		return "/WEB-INF/views/data04.jsp";
	}
	
//	데이터가 항상 변수로 존재라는 것은 아니다
//	(EX : 목록이나 검색은 데티어가 배열 또는 List 형태로 존재한다.)
	@GetMapping("/data05")
	public String data05(Model model) {
		int[] lotto = new int[] {10, 13, 24, 25, 37, 41};
		model.addAttribute("lotto", lotto);
		return "/WEB-INF/views/data05.jsp";
	}
	
	@GetMapping("/table01")
	public String table01() {
		return"/WEB-INF/views/table01.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
