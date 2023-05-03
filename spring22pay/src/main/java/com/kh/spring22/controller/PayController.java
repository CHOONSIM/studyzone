package com.kh.spring22.controller;

import java.net.URISyntaxException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring22.service.KakaoPayService;
import com.kh.spring22.vo.KakaoPayApproveRequestVO;
import com.kh.spring22.vo.KakaoPayApproveResponseVO;
import com.kh.spring22.vo.KakaoPayReadyRequestVO;
import com.kh.spring22.vo.KakaoPayReadyResponseVO;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	@GetMapping("/test1")
	public String test1() {
		return "/pay/test1";
	}
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@PostMapping("/test1")
	public String test1(
			@ModelAttribute KakaoPayReadyRequestVO vo,
			HttpSession session
			) throws URISyntaxException {
		//정보추가(주문자번호, 주문번호)
		vo.setPartner_order_id(UUID.randomUUID().toString());
//		vo.setPartner_user_id((String)session.getAttribute("memberId"));
		vo.setPartner_user_id("adminuser200");
		
		//준비요청
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo);
		
		//세션에 데이터 임시 첨부(partner_order_id, partner_user_id, tid
		session.setAttribute("partner_order_id", vo.getPartner_order_id());
		session.setAttribute("partner_user_id", vo.getPartner_user_id());
		session.setAttribute("tid", response.getTid());
		
		//사용자를 결제페이지로 리다이렉트
		return "redirect:" + response.getNext_redirect_pc_url();
	}
	
	//test1 결제 성공 매핑
	@GetMapping("/test1/success")
	public String test1Success(
//			@RequestParam String pg_token
			@ModelAttribute KakaoPayApproveRequestVO vo,
			HttpSession session
			) throws URISyntaxException {
		//cid, partner_order_id, partner_user_id, tid, pg_token 필요
		// 메소드에는 pg_token밖에 없다
		// 승인을 하기 위해서는 *준비 단계에서 만든 정보*가 필요하다
		// -> 같은 브라우저에서만 데이터가 전달되도록 HttpSession을 사용
		
		//세션에 데이터 임시 추출/삭제(partner_order_id, partner_user_id, tid
		vo.setPartner_order_id((String)session.getAttribute("partner_order_id"));
		vo.setPartner_user_id((String)session.getAttribute("partner_user_id"));
		vo.setTid((String)session.getAttribute("tid"));
		
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		
		KakaoPayApproveResponseVO response = kakaoPayService.approve(vo);
		
//		return "redirect:결제완료페이지";
		//return "redirect:/pay/test1/clear;
		return "redirect:clear";
	}
	
	@GetMapping("/test1/clear")
	public String test1Clear() {
		return "pay/clear";
	}
}
