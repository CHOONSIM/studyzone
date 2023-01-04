package loop;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		//새해 맞이 다이어트
		//푸쉬업 30일 동안
		//첫날 5개 둘째날부터는 전날보다 2개씩 개수를 늘려서
		// 1. 일자별로 하게되는 푸시업 개수
		// 2. 30일동안 하게되는 푸시업 개수 합
		// 3. 첫날 개수와 증가 폭, 기간을 입력받아서 출력
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("날짜(일)을 입력하세요.");
		int period = sc.nextInt();
	    
		System.out.println("첫날개수를 입력하세요.");
		int pushup = sc.nextInt();
		
		System.out.println("증가 폭을 입력하세요.");
		int increase = sc.nextInt();
		
		sc.close();
		
		int total = 0;
		
		for(int day = 1; day<= period; day++) {
			System.out.println(day + "일차" + pushup + "개");
			total += pushup;
			pushup += 2;
		}	
		System.out.println("총 개수 : " + total);

	}

}