package com.kh.spring22;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

//목표 : 결제 승인 테스트(Test02를 반드시 먼저 실행한 뒤 해야함)
@Slf4j
@SpringBootTest
public class Test03 {

	@Test
	public void test() throws URISyntaxException {
		//데이터
		String partner_order_id = "bb29e2e9-01a2-4538-b079-ebdbbd5ce5a3";
		String partner_user_id = "1a8954b8-e770-4819-b121-791f3dcd667c";
		String tid = "T450a76941ce08910596";
		String pg_token = "f928e7e0befedc353c8d";
		
		//전송 도구 생성
		RestTemplate template = new RestTemplate();
		
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 9a7aaa1fb3ac3d24b990f9258b0ed8e4");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("partner_order_id", partner_order_id);
		body.add("partner_user_id", partner_user_id);
		body.add("tid", tid);
		body.add("pg_token", pg_token);
		
		//헤더 + 바디
		HttpEntity entity = new HttpEntity(body, headers);
		
		//요청 및 응답 저장
		Map response = template.postForObject(uri, entity, Map.class);
		log.debug("response = {}", response);
	}
	
}
