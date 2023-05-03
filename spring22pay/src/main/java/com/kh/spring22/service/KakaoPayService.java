package com.kh.spring22.service;

import java.net.URISyntaxException;

import com.kh.spring22.vo.KakaoPayApproveRequestVO;
import com.kh.spring22.vo.KakaoPayApproveResponseVO;
import com.kh.spring22.vo.KakaoPayReadyRequestVO;
import com.kh.spring22.vo.KakaoPayReadyResponseVO;

public interface KakaoPayService {

	// 준비 - ready
//	카카오페이 결제 준비 응답데이터 ready(카카오페이 결제 준비 요청데이터);
	KakaoPayReadyResponseVO ready (KakaoPayReadyRequestVO vo) throws URISyntaxException;
	
	// 승인 - approve
	KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO vo) throws URISyntaxException;
	
	// 조회 - order
//	KakaoPayOrderResponseVO order(KakaoPayOrderRequestVO vo);
}
