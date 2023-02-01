package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.dto.SubjectDto;

@Controller
@RequestMapping("/member")
public class MemberController {

//	등록
	@Autowired
	private MemberDao dao;

	@RequestMapping("/newbie")
	@ResponseBody
	public String newbie(@ModelAttribute MemberDto dto) {
		dao.newbie(dto);
		return "회원가입이 완료되었습니다.";
	}
	
//	목록검색
	@RequestMapping("/listandsearch")
	@ResponseBody
	public String listandsearch(
			@RequestParam(required = false, defaultValue = "member_id")String column,
			@RequestParam(required = false, defaultValue = "")String keyword,
			@RequestParam String memberPw) {
		boolean search = !keyword.equals("");
		
		List<MemberDto>list;
		if(search) 
			list = dao.selectList(column, keyword);
		else
			list = dao.selectList();
		
		StringBuffer buffer = new StringBuffer();
		
		for(MemberDto dto : list) {
			buffer.append(dto.toString());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
//	상세
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam String memberId) {
	MemberDto dto = dao.selectOne(memberId);
	if(dto==null) 
		return"가입이력이 없습니다.";
	else
		return dto.toString();
}
	
//	수정
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(@ModelAttribute MemberDto dto) {
		boolean done = dao.update(dto);
		return done ?"개인정보변경 완료" : "잘못된 입력입니다. ";
	}
	
//	삭제
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam String memberId) {
		boolean done = dao.delete(memberId);
		if(done)
			return "계정이 삭제 되었습니다.";
		else
			return "잘못된 입력입니다.";
	}

}