package com.kh.spring22;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

// 목표 : Test01을 결제 승인 테스트에 필요한 정보를 출력하면서 진행하도록 변경
@Slf4j
@SpringBootTest
public class Test02 {

	@Test
	public void test() throws URISyntaxException {
		//서버에서 다른 서버로 요청을 보낵시 위해서는 다음 두 가지 중 하나가 필요
		// [1] RestTemplate
		// [2] WebClient
		
		//데이터 준비
		String partner_order_id = UUID.randomUUID().toString();
		String partner_user_id = UUID.randomUUID().toString();
		String item_name = "한남동 자가";
		int quantity = 1;
		int total_amount = 10000000; 
		//전송 도구 생성
		RestTemplate template = new RestTemplate();
		
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 4195e083b09587f091d19483cb056cac");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		// a=value1&b=value2&c=value3 -> MultiValueMap
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("tid", "TC0ONETIME");		// 성공 시 응답데이터
		body.add("partner_order_id",partner_order_id);		//준비단계에서의 데이터
		body.add("partner_user_id",  partner_user_id);		//준비단계에서의 데이터
		body.add("pg-token", null);							//성공 시 발행되는 데이터
		body.add("item_name", item_name);
		body.add("quantity", String.valueOf(quantity));
		body.add("total_amount", String.valueOf(total_amount));
		body.add("tax_free_amount", "0");
		body.add("approval_url", "http://localhost:8080/success");
		body.add("fail_url", "http://localhost:8080/fail");
		body.add("cancel_url", "http://localhost:8080/cancel");
		
		
		//헤더 + 바디(entity= 하나의 덩어리진 객체)
		HttpEntity entity = new HttpEntity(body, headers);
		
		
		//요청 보내기
		Map response = template.postForObject(uri, entity, Map.class);
//		log.debug("response={}", response);
		log.debug("partner_order_id = {}", partner_order_id);
		log.debug("partner_user_id = {}", partner_user_id);
		log.debug("tid = {}", response.get("tid"));
		log.debug("url = {}", response.get("next_redirect_app_url"));
	}
	
}
