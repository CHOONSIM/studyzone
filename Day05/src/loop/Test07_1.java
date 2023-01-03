package loop;

import java.util.Scanner;

public class Test07_1 {

	public static void main(String[] args) {
		//새해 맞이 다이어트
		//푸쉬업 30일 동안
		//첫날 5개 둘째날부터는 전날보다 2개씩 개수를 늘려서
		// 1. 일자별로 하게되는 푸시업 개수
		// 2. 30일동안 하게되는 푸시업 개수 합
		// 3. 첫날 개수와 증가 폭, 기간을 입력받아서 출력
		
		
		//문제 풀이
		
		// 1. 문제
		//공식(어려움)
		//5+2*(n-1)
//		for(int day = 1; day<= 30; day++) {
//			int pushup = 5+2 * (day-1);
//			System.out.println(day);
//		}	
		
	
		// 권장
		// -pushup 개수를 누적시킬 변수를 지저아고 누적연산
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("기간(일) 입력");
		int period = sc.nextInt();
		
		System.out.println("첫날 개수 입력");
		int pushup = sc.nextInt();
		
		System.out.println("증가 개수 입력");
		int increase = sc.nextInt();
		
		
		int total = 0;   //합계
		
		for(int day = 1; day<= 30; day++) {
			System.out.println(day+"일차 - "+pushup + "개");
			total +=pushup;     //합계
			pushup += 2;
		}
		System.out.println("총 개수 : "+total);   //합계
	
	}

}
