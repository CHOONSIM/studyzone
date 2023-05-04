package com.kh.spring22.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring22.dto.PaymentDto;
import com.kh.spring22.repo.PaymentRepo;
import com.kh.spring22.service.KakaoPayService;
import com.kh.spring22.vo.KakaoPayApproveRequestVO;
import com.kh.spring22.vo.KakaoPayApproveResponseVO;
import com.kh.spring22.vo.KakaoPayCancelRequestVO;
import com.kh.spring22.vo.KakaoPayCancelResponseVO;
import com.kh.spring22.vo.KakaoPayOrderRequestVO;
import com.kh.spring22.vo.KakaoPayOrderResponseVO;
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
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@GetMapping("/test1/list")
	public String list(Model model) {
//		String memberId = (String)session.getAttribute("memberId");
		String memberId = "adminuser200";
		List<PaymentDto>list = paymentRepo.selectByMember(memberId);
		model.addAttribute("list",list);
		return"/pay/list";
	}
	
	@GetMapping("/test1/detail")
	public String detail(@RequestParam int paymentNo, Model model) throws URISyntaxException {
		//우리 DB에서 정보를 찾아라
		PaymentDto paymentDto = paymentRepo.find(paymentNo);

		//찾은 정보에서 TID를 조회하여 카카오페이에서 실제 정보를 조회하라
		KakaoPayOrderRequestVO vo = new KakaoPayOrderRequestVO();
		vo.setTid(paymentDto.getPaymentTid());
		KakaoPayOrderResponseVO response = kakaoPayService.order(vo);

		//모든 정보를 Model에 첨부
		model.addAttribute("paymentDto", paymentDto);
		model.addAttribute("response", response);

		//상세 페이지 반환
		return "pay/detail";//"/WEB-INF/views/pay/detail.jsp"
	}
	
	@GetMapping("/test1/cancel")
	public String cancel(
			@RequestParam int paymentNo,
			HttpServletResponse resp,
			RedirectAttributes attr
			) throws URISyntaxException, IOException, NoHandlerFoundException {
		//[1] paymentNo로 PaymentDto 정보를 조회
		PaymentDto paymentDto = paymentRepo.find(paymentNo);
		
		//써드파티 부르기 전에 검사
		if(paymentDto == null || paymentDto.getPaymentRemain() == 0)
//			resp.sendError(500);	//사용자에게 500 에러를 내보내기(수동명령)
//			return null;
			throw new NoHandlerFoundException(null, null, null);
			
		//[2] 1번에서 구한 정보의 TID와 잔여금액 정보로 카카오에게 취소 요청(써드파티 부르는 곳)
		KakaoPayCancelRequestVO vo = new KakaoPayCancelRequestVO();
		vo.setTid(paymentDto.getPaymentTid());
		vo.setCancel_amount(paymentDto.getPaymentRemain());
		
		KakaoPayCancelResponseVO response = kakaoPayService.cancel(vo);
		
		//[3] 내 DB의 잔여 금액을 0으로 변경(paymentRepo)
		paymentRepo.cancelRemain(paymentNo);
		
		//[4] 상세페이지로 돌려보내기
//		return "redirect:detail?paymentNo="+paymentNo;
		attr.addAttribute("paymentNo", paymentNo);
		return "redirect:detail";
	}
	
	
}