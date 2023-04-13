package com.kh.semi.spring15;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

//Lombok이 Logger를 자동 생성해준다
@Slf4j
@SpringBootTest
public class Test02 {

// 이 도구를 자동 생성
//	private static final Logger log = LoggerFactory.getLogger(Test02.class);
	
		@Test
		public void test() {
			log.debug("롬복이 자동 생성해줌");
			log.debug("10+20=30");
			
			int a =10 ,b=20, c=a+b;
			log.debug(a+"+"+b+"="+c);
			
			//  {} = 홀더
			log.debug("{} + {} = {}",a,b,c);
			
		}
}
