package com.kh.spring22;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring22.service.KakaoPayService;
import com.kh.spring22.vo.KakaoPayApproveRequestVO;
import com.kh.spring22.vo.KakaoPayApproveResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test05 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		
		KakaoPayApproveRequestVO vo = new KakaoPayApproveRequestVO();
		vo.setPartner_order_id("434257b1-b89e-4cfd-b8cb-d7d2e2af3dc4");
		vo.setPartner_user_id("bff5f587-c4d0-4c21-9de9-8557be8f7bb7");
		vo.setTid("T451e55c41ce08911252");
		vo.setPg_token("1af45e928cbd95486d6b");
		
		KakaoPayApproveResponseVO response = kakaoPayService.approve(vo);
		log.debug("response = {}", response);
	}
	
}
