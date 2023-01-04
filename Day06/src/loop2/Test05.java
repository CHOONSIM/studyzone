package loop2;

import java.util.Scanner;

public class Test05 {
	public static void main (String[] args) {
		
		//do~while 반복 (사용하지 않음)
		// 1. 사람들이 사용하지 않음
		// 2. 구문이 어려움(격식이 많이 갖춰야 함)
		
		// ex) 사용자에게 점수(0~100)을 입력받는 예제
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		do {
			System.out.println("정수 입력");
			score =sc.nextInt();
		}
		while(!(score >= 0 && score <=100)); //(점수를 잘못 입력했다면)
	    
		sc.close();
	}

}
