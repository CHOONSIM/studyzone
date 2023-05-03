package com.kh.spring22.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring22.configuration.KakaoPayProperties;
import com.kh.spring22.vo.KakaoPayApproveRequestVO;
import com.kh.spring22.vo.KakaoPayApproveResponseVO;
import com.kh.spring22.vo.KakaoPayReadyRequestVO;
import com.kh.spring22.vo.KakaoPayReadyResponseVO;

@Service
public class KakaoPayServiceImpl implements KakaoPayService{
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private HttpHeaders headers;
	
	@Autowired
	private KakaoPayProperties properties;
	
	@Override
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO vo) throws URISyntaxException {
		//주소생성
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//바디생성
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", properties.getCid());
		body.add("partner_order_id", vo.getPartner_order_id());
		body.add("partner_user_id", vo.getPartner_user_id());
		body.add("item_name", vo.getItem_name());
		body.add("quantity", String.valueOf(vo.getQuantity()));
		body.add("total_amount", String.valueOf(vo.getTotal_amount()));
		body.add("tax_free_amount", "0");
		body.add("approval_url", "http://localhost:8080/success");
		body.add("fail_url", "http://localhost:8080/fail");
		body.add("cancel_url", "http://localhost:8080/cancel");
		
		//바디 + 헤더
		HttpEntity entity = new HttpEntity(body, headers);
		
		//요청 전송
		KakaoPayReadyResponseVO response = template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		return response;
	}

	@Override
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO vo) throws URISyntaxException {
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", properties.getCid());
		body.add("partner_order_id", vo.getPartner_order_id());
		body.add("partner_user_id", vo.getPartner_user_id());
		body.add("tid", vo.getTid());
		body.add("pg_token", vo.getPg_token());
		
		//헤더 + 바디
//		HttpEntity entity = new HttpEntity(body, headers);
		HttpEntity <MultiValueMap<String,String>> entity = new HttpEntity<>(body, headers);
		
		//전송
		KakaoPayApproveResponseVO response = template.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
		
		return response;
	}
	
}
