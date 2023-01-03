package loop;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		
//		30일동안 첫날은 1원
//		둘째날부터는 두 배 
//		
//		1. 이 노인이 일자별로 받는 돈을 출력
//		2. 이 노인이 받는 총 금액을 출력
//		3. 기간이 40일로 늘어나면 얼마를 받는지 출력
		
		
		int totalDay = 30;
		long money = 1;
		long total = 0;

		for(int day=1; day<=totalDay; day++) {
			System.out.println(day + "일차 " + money +"원");
			total += money;
			money *= 2;
		}
		System.out.println("총 금액 : "+total + " 원");
		
	}

}
