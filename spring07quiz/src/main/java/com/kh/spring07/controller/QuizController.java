package com.kh.spring07.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//	Spring의 제1 특징 : 제어 반전(Inversion Of Control, IOC)
//	- 주도권을 개발자가 아닌 애플리케이션이 갖는다.
//	- 생성을 하지말고 등록을 해라.
//	- 등록만 역할에 맞게 제대로하면 나머지 처리는 스프링이 해준다.
//	required와 defaultvalue를 조합하여 없는 겨우를 처리할 수 있다.
//	통신은 원래 문자열이나 byte만 전송이 가능하므로 defaultValue는 문자열이다.

@Controller
public class QuizController {
	
	@RequestMapping("/theater")
	@ResponseBody
	public String theater(
			@RequestParam (required=false, defaultValue = "0") int adult, 	//null이면 0으로 치환
			@RequestParam (required=false, defaultValue = "0") int teen) {
		int adultPrice = 16000; int teenPrice = 10000; 
		int totalAdult = adultPrice * adult;
		int totalTeen = teenPrice * teen;
		return "어른 총 금액 : " + totalAdult + "원 입니다. " + "청소년 총 금액 : "+
				totalTeen + "원 입니다.";
	}
	
	
	@RequestMapping("/china")
	@ResponseBody
	public String china(
			@RequestParam (required=false) int jjajang,
			@RequestParam (required=false) int champon) {
		int jjajangPrice = 16000; int champonPrice = 10000; 
		int totalJjajang = jjajangPrice * jjajang;
		int totalChampon = champonPrice * champon;
		Format f = new DecimalFormat("#,##0");
		return "짜장 총 금액 : " +f.format(totalJjajang) + "원 입니다. " + "짬뽕 총 금액 : "+
				f.format(totalChampon) + "원 입니다.";
	}
	
	@RequestMapping("/BMI")
	@ResponseBody
	public String BMI(
			@RequestParam double height,
			@RequestParam double weight) {
		double heightm = height /100;
		double result = weight / (heightm*heightm) ;
		if(result >= 24.5) {
		return  "당신의 BMI 지수 : " + result + "과체중입니다.";
	}
	else{
		return  "당신의 BMI 지수 : " + result + " 정상체중입니다.";
	 }
	}
	
	@RequestMapping("/subway")
	@ResponseBody
	public String subway(
			@RequestParam(required=false) int birth) {
		int card = 500; int adult = 1250; int teen = 720; int child = 450;
		int age =  LocalDate.now().getYear()- birth + 1;
		
		if(age >= 65) {
			return card + " 원 입니다.";
		}
		else if(age >= 20) {
			return card + adult + " 원 입니다.";
		}
		else if(age >= 14) {
			return card + teen + " 원 입니다.";
		}
		else if(age >= 8) {
		return card + child + " 원 입니다.";
		}
		else {
			return card + " 원 입니다.";
		}
	}
	
	@RequestMapping("/pcroom")
	@ResponseBody
	public String pcroom(
			@RequestParam (required=false)int start,
			@RequestParam (required = false)int end) {
		int pcCharge = 1300;
		int totalHour = (end-start) / 100;
		int totalMin = (end-start) % 100;
		
		double minCharge = pcCharge / 60;
		int pcChargeH = totalHour * pcCharge;
		double pcChargeM = totalMin * minCharge;
		double pcCharge1 = pcChargeH + pcChargeM;
		double pcCharge2 = pcCharge1 * 0.01;
		int pcCharge3 = (int)pcCharge2;
		int totalCharge = pcCharge3 * 100; 
		Format f = new DecimalFormat("#,##0");
		return "총 이용요금 : " + f.format(totalCharge) + " 원 입니다.";
	}

	
	
	
	
	
	
	
	
	
	

}
