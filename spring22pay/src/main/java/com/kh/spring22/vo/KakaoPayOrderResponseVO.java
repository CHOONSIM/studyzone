package com.kh.spring22.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class KakaoPayOrderResponseVO {

	private String tid; // 결제 고유 번호
	private String cid;	// 가맹점 코드
	private String status;	// 결제 상태
	private String partner_order_id; // 가맹점 주문번호
	private String partner_user_id; // 가맹점 회원 id
	private String payment_method_type;// 결제수단
	
	private KakaoPayAmountVO amount;
	private KakaoPayAmountVO canceled_amount;
	private KakaoPayAmountVO canceled_available_amount;
	
	private String item_name; // 상품명
	private String item_code;
	private int quantity; // 상품 수량
	
	private Date created_at; // 결제 준비 요청 시간
	private Date approved_at;
	private Date canceled_at;
	
	private KakaoPaySelectedCardInfoVO selected_card_info;
	private KakaoPayPaymentActionDetailVO payment_action_details;

}
