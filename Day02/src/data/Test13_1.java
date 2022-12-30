package data;
import java.lang.*;

public class Test13_1 {
	public static void main(String[] args) {
		//pc방 요금이 한시간에 1300원
		//오전 9시 50분부터 오후 1시 35분까지 이용한 고객의 요금을 출력
		//단, 십원 단위는 받지 않습니다.(99원까지는 할인 처리)
		
		//과제풀이
		
		//입력 ; 시간당요금, 시작시각, 종료시작
		int pricePerHour = 1300;
		int startHour = 9 , startMinute = 50;
		int finishHour = 13 , finishMinute = 35;
		
		
		//처리
		int startTime = startHour * 60 + startMinute;
		int finishTime = finishHour * 60 + finishMinute;
		int usageTime = finishTime - startTime;
		
		//System.out.println(pricePerHour / 60);
		//System.out.println(pricePerHour / 60.0);
		double pricePerMinute = pricePerHour / 60.0;
		int price = (int)(pricePerMinute * usageTime);	//소수점 삭제
		
		int hour = usageTime / 60; 
		int minute = usageTime & 60;
		
		//출력
		
		System.out.println("이용시간은 다음과 같습니다");
		System.out.println(3);
		System.out.println(45);
		System.out.println("이용요금은 다음과 같습니다");
		System.out.println(price);
		
		//버림 ex)
		int price2 = price /100 * 100;
		System.out.println("버림 결과");
		System.out.println(price2);
		
		//반올림 
		// ~ 49 는 0 , 50 ~ 는 100 (경계찾기) (50을 더해서 버리면 반올림) (두 자리 숫자 예시)
		int price3 = (price + 50) / 100 * 100;
		System.out.println("반올림 결과");
		System.out.println(price3);
		
		//올림
		int price4 = (price + 99) / 100 * 100;
		System.out.println("올림 결과");
		System.out.println(price4);
	}
}