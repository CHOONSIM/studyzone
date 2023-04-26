package com.kh.spring19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// 이 프로그램에서는 스케쥴링 기능을 쓸것이다. 
// 스케쥴링은 무리가 많이가므로 스프링부트에서 시작페이지에 선언을 안해주면 사용을 못함
@EnableScheduling
@SpringBootApplication
public class Spring19restapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring19restapiApplication.class, args);
	}

}
