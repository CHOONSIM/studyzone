package com.kh.spring07.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
			@RequestParam int birth) {
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
			@RequestParam int start,
			@RequestParam int end) {
		int pcCharge = 1300;
		int totalHour = (end-start) / 100;
		int totalMin = (end-start) % 100;
		
		double minCharge = (double)pcCharge / 60;
		int pcChargeH = totalHour * pcCharge;
		double pcChargeM = totalMin * minCharge;
		double pcCharge1 = pcChargeH + pcChargeM;
		double pcCharge2 = pcCharge1 * 0.01;
		int totalCharge = (int)pcCharge2 * 100; 
		Format f = new DecimalFormat("#,##0");
		return "총 이용요금 : " + f.format(totalCharge) + " 원 입니다.";
	}
	
	@RequestMapping("/sum")
	@ResponseBody
	public String sum(
			@RequestParam (required = false, defaultValue = "0")int start,
			@RequestParam (required = false)int end) {
		int total =0;
		for(int i=start; i<=end; i++) {
			total += i;
		}
		return "총 합 : " + total;
	}
	
	@RequestMapping("/score")
	@ResponseBody
	public String score(
			@RequestParam(required = false, defaultValue = "0")int korean,
			@RequestParam(required = false, defaultValue = "0")int english,
			@RequestParam(required = false, defaultValue = "0")int math) {
		double average = (korean + english + math) / 3.0;
		if(korean >= 40 && english >=40 && math >=40 && average >=60) {
			return "평균 점수 " + average +" 점으로 합격입니다.";
		}
		return "평균 점수" + average + " 점으로 불합격입니다.";
	}
	
	
	@RequestMapping("/leap")
	@ResponseBody
	public String leap(
			@RequestParam int year) {
			
		if((year % 4 == 0) && (year % 100 != 0) ||( year % 400 == 0)) {
			return year + "년도는 윤년입니다.";
			}
			return year + "년은 윤년이 아닙니다.";
	}
	
	
//	파라미터가 너무 많거나 의미가 있는 데이터(객체)인 경우
//		->클래스를 만들어서 필드를 원하는 형태로 구성한 뒤 자동 수신을 부탁
//		-> @ModelAttribute를 사용
//			-> 자동으로 올려주지만 자료가 없어도 올려줌(null, 0)
//			-> 파라미터를 강제하기 어려움(추가 검사 및 예외처리가 필요)
//	ex) 학생 정보(이름,점수)
	
	@RequestMapping("/student")
	@ResponseBody
//	public String student(Student 클래스를 이용하여 알아서 받아주세요) {
	public String student(@ModelAttribute Student stu) {
		return "받은 데이터 : " + stu.toString();
	}
	
}
