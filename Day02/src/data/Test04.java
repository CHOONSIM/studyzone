package data;
import java.lang.*;

public class Test04 {
	public static void main(String[] args) {
		//목표 : Test03을 고치기 쉽도록 프로그램을 개조
		//프로그램은 입력 -> 처리 -> 출력 의 구조를 갖는다.
		
		//입력 : 성인요금, 청소년요금, 성인인원수, 청소년인원수 - 저장
		// 정수 형태로 성인요금을 16000이라는 값으로 저장
		int adultPrice = 16000; //대입연산   adult_price : snake case, adultPrice : camel case
		int teenPrice = 10000;
		int adultCount = 2;
		int teenCount = 3;
		//처리 
		int adultTotal = adultPrice * adultCount;
		int teenTotal = teenPrice * teenCount;
		
		int total = adultTotal + teenTotal;
	    //출력 : 총 요금
		System.out.println(total);
	}

}
