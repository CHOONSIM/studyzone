package com.kh.spring05.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuizController {

	@RequestMapping("/lotto")
	@ResponseBody
	public String lotto() {
		Random r = new Random();
		int number = r.nextInt(45)+1;
		return "로또 번호 : " + number;
		}
	
	@RequestMapping("/lotto2")
	@ResponseBody
	public String lotto2() {
	Set<Integer> lottoNum = new TreeSet<>();
	Random r = new Random();
		while(lottoNum.size() < 6) {
			lottoNum.add(r.nextInt(45) + 1);
		}
		StringBuffer buffer = new StringBuffer();
		for(int lotto : lottoNum) {
			buffer.append("로또 번호 : " + lotto);
			buffer.append("<br>");
		}
		return buffer.toString();
		}
	
	@RequestMapping("/otp")
	@ResponseBody
	public String otp() {
		Random r = new Random();
		Format f = new DecimalFormat("000000");
		while(true) {
			long time = System.currentTimeMillis() / 1000L; 
			r.setSeed(time);
			int otp = r.nextInt(1000000) + 0;
			return "OTP = " + f.format(otp);
		}
	}
	
}
