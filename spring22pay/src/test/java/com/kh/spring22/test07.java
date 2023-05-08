package com.kh.spring22;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class test07 {

	@Test
	public void test() {
		//목표 : WebClient를 이용하여 RestTemplate과 동일한 요청처리(Webflux)
		WebClient client = WebClient.create();
		String response = client.get()
			.uri("https://www.naver.com")
			.retrieve()
			.bodyToMono(String.class)		//Mono : 단일조회(데이터1개)	//flux : 목록조회(데이터 1개이상)
			.block();
		log.debug("response = {}", response);
	}
}
