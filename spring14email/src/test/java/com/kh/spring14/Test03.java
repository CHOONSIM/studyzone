package com.kh.spring14;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

// 목표 : MIME Message를 전송
@SpringBootTest
public class Test03 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException {
		//[1] 메세지 생성 - sender에게 생성하도록 지시
		MimeMessage message = sender.createMimeMessage();
		
		//[2] 메세지 헬퍼 생성 - 각종 처리를 쉽게 할 수 있도록 도와주는 역할
		MimeMessageHelper helper = new MimeMessageHelper(message,false, "UTF-8");
		
		//[3] 헬퍼에 정보 설정
		helper.setTo("yoyyo9402@gmail.com");
		helper.setSubject("23-04-26 테스트");
		//helper.setText("<h1>23-04-26 테스트<h1>");  // html 사용 불가
		helper.setText("<h1>23-04-26 테스트<h1>",true);	// html 사용 설정
		
		//[4] 전송
		sender.send(message);
	}
}
