package com.kh.spring22.vo;

import lombok.Data;

@Data
public class KakaoPayOrderRequestVO {
	
    private String partner_order_id; // 가맹점 주문번호
    private String partner_user_id; // 가맹점 회원 id
    private String item_name; // 상품명
    private int quantity; // 상품 수량
    private int total_amount; // 상품 총액
    private int tax_free_amount; // 상품 비과세 금액
    private String approval_url; // 결제 성공시 redirect url
    private String cancel_url; // 결제 취소시 redirect url
    private String fail_url; // 결제 실패시 redirect url
}
