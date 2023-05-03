package com.kh.spring22;

import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring22.service.KakaoPayService;
import com.kh.spring22.vo.KakaoPayReadyRequestVO;
import com.kh.spring22.vo.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

// 목표 : KakaoPayService를 사용하여 결제 준비 테스트
@Slf4j
@SpringBootTest
public class Test04 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		//데이터 준비
		KakaoPayReadyRequestVO vo = new KakaoPayReadyRequestVO();
		vo.setPartner_order_id( UUID.randomUUID().toString());
		vo.setPartner_user_id( UUID.randomUUID().toString());
		vo.setItem_name("용산 아파트");
		vo.setQuantity(1);
		vo.setTotal_amount(100000);
		
		//처리
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo);
		
		//출력
		log.debug("request = {}", vo);
		log.debug("response = {}", response);
		
	}
}
