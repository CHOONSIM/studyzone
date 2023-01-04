package random;

import java.util.Random;
import java.util.Scanner;

public class Test05_1 {
	public static void main(String[] main) {
		
		//랜덤으로 10개의 구구단 문제를 출제하고, 사용자가 이를 풀 수 있도록 구현
		//횟수니까 for문 사용
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		for(int i=0; i < 10; i++) {
			int a = r.nextInt(8)+2;
			int b = r.nextInt(9)+1;
			System.out.println(a + " X " + b+ "=");
			
			int user = sc.nextInt();
			if(a*b == user) {
				System.out.println("정답");
			}
			else {
				System.out.println("오답");
			}
		}
		sc.close();
	}

}
