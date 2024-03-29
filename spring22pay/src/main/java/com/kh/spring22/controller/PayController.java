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

import com.kh.spring22.dto.ItemDto;
import com.kh.spring22.dto.PaymentDetailDto;
import com.kh.spring22.dto.PaymentDto;
import com.kh.spring22.repo.ItemRepo;
import com.kh.spring22.repo.PaymentDetailRepo;
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
import com.kh.spring22.vo.PaymentListVO;
import com.kh.spring22.vo.PurchaseListVO;
import com.kh.spring22.vo.PurchaseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	//---------------------------------------------------------------------------------------------//
	
	@Autowired
	private ItemRepo itemRepo;
	
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("itemList",itemRepo.list());
		return"pay/test2";
	}
	
	//객체 배열 형태로 전송되는 데이터를 수신하는 처리(ex: data[0].qty)(@ModelAttribute List못받음 클래스만들어서 넣기)
	@PostMapping("/test2")
	public String test2(@ModelAttribute PurchaseListVO listVO,
			HttpSession session) throws URISyntaxException {
		// 전달받은 내용에서 결제 정보를 생성
		String name="";
		int total=0;
		int count = 0;
		
		log.debug("데이터 개수 ={}",listVO.getData().size());
		for(PurchaseVO vo : listVO.getData()) {
//			log.debug("vo ={}", vo);
			//[1] vo에 있는 상품번호로 상품정보(ItemDto)를 불러와야 한다.
			ItemDto itemDto = itemRepo.find(vo.getItemNo());
			
			//[2] 상품이름과 상품가격을 조회하여 필요한 정보를 계산한다.
			name = itemDto.getItemName();
			total += itemDto.getItemDiscount() * vo.getQty();
			count ++;
		}
		
		KakaoPayReadyRequestVO request = new KakaoPayReadyRequestVO();
		request.setPartner_order_id(UUID.randomUUID().toString());
		request.setPartner_user_id("adminuser200");
		request.setItem_name(name+"외"+(count-1)+"건");
		request.setQuantity(1);
		request.setTotal_amount(total);
		
		KakaoPayReadyResponseVO response = kakaoPayService.ready(request);
		
		//flash value(잠깐 쓰는 데이터)
		//세션에 데이터 임시 첨부(partner_order_id, partner_user_id, tid)
		//(+추가) 구매내역 (번호+수량)
		session.setAttribute("partner_order_id", request.getPartner_order_id());
		session.setAttribute("partner_user_id", request.getPartner_user_id());
		session.setAttribute("tid", response.getTid());
		session.setAttribute("listVO",listVO);
		
		return "redirect:" + response.getNext_redirect_pc_url();
	}
	
	@GetMapping("/test2/success")
	public String test2Success(
			HttpSession session,
			@ModelAttribute KakaoPayApproveRequestVO vo) throws URISyntaxException {
		vo.setPartner_order_id((String)session.getAttribute("partner_order_id"));
		vo.setPartner_user_id((String)session.getAttribute("partner_user_id"));
		vo.setTid((String)session.getAttribute("tid"));
		PurchaseListVO listVO = (PurchaseListVO)session.getAttribute("listVO");
		
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		session.removeAttribute("listVO");
		//session.invalidate(); 으로 작성하면 세션이 사라짐(전체가 사라짐, 사용X 골라서 지우기)
		
		
		//결제 상세 내역을 등록하는 코드 필요(외 몇건에 대한 내용)(결제 대표 번호가 필요,approve에 있음)
		//결제된 데이터가 db에도 남아야함
		
		KakaoPayApproveResponseVO response = kakaoPayService.approveWithDetail(vo, listVO);
		
		
		return"redirect:clear";//redirect:/pay/test2/clear
	}
	
	//보여줄 페이지 따로 만드는 이유 새로고침에 영향 받지 않으려고
	@GetMapping("/test2/clear")
	public String test2Clear() {
		return "pay/clear";
	}
	
	@GetMapping("/test2/list")
	public String test2List(Model model) {
		//	List<PaymentListVO>list = paymentRepo.treeSelect();	//전체 조회
		List<PaymentListVO>list = paymentRepo.treeSelect("adminuser200");
		model.addAttribute("list",list);
		return "pay/list2";
	}
	
	//취소 = 전체취소 / 부분취소
	
	//전체취소는 다음 작업들을 수행해야 한다.
	//[1] 카카오에 취소 요청
	//[2] 결제 대표정보에 잔여금액을 0으로 변경
	//[3] 결제 상세정보에 해당 결제와 관련된 항목들을 취소 상태로 변경
	
	@Autowired
	private PaymentDetailRepo paymentDetailRepo; 
	
	@GetMapping("/test2/refundAll")
		public String refundAll(@RequestParam int paymentNo) throws URISyntaxException {
			PaymentDto paymentDto = paymentRepo.find(paymentNo);
			
			//순서 중요
			//[1]
			KakaoPayCancelRequestVO request = new KakaoPayCancelRequestVO();
			request.setTid(paymentDto.getPaymentTid());
			request.setCancel_amount(paymentDto.getPaymentRemain());
			KakaoPayCancelResponseVO response = kakaoPayService.cancel(request);
			
			//[2]
			paymentRepo.cancelRemain(paymentNo);	//잔여금액 초기화, 현재 상태 모두 완료
			
			//[3]
			paymentDetailRepo.cancelPaymentDetail(paymentNo);
			
			return "redirect:list";
	}
	
	//항목 취소(부분 취소)
	//[1] 카카오에 해당 항목만큼의 금액을 취소 요청
	//[2] 해당 항목의 결제 상태를 '취소'로 변경
	//[3] 해당 항목이 포함된 대표 결제에서 잔여 금액을 차감
	
	
	@GetMapping("/test2/refundItem")
	public String refundItem(@RequestParam int paymentDetailNo) throws URISyntaxException {
		//조회
		PaymentDetailDto paymentDetailDto = 
							paymentDetailRepo.find(paymentDetailNo);
		PaymentDto paymentDto = 
							paymentRepo.find(paymentDetailDto.getPaymentNo());
		
		//[1] 
		KakaoPayCancelRequestVO request = new KakaoPayCancelRequestVO();
		request.setTid(paymentDto.getPaymentTid());
		request.setCancel_amount(paymentDetailDto.getItemTotal());
		KakaoPayCancelResponseVO response = kakaoPayService.cancel(request);
		
		//[2]
		//update payment_detail set payment_detail_status='취소'
		//where payment_detail_no=?
		paymentDetailRepo.cancelPaymentDetailItem(paymentDetailNo);
		
		//[3]
		//update payment 
		//set payment_remain = payment_remain - ?
		//where payment_no = ?
		paymentRepo.cancelRemain(
				paymentDto.getPaymentNo(),//결제대표번호
				paymentDetailDto.getItemTotal()//취소시킬 금액
		);
		
		return "redirect:list";
	}
}
