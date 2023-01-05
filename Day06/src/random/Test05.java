package random;

import java.util.Random;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		//구구단 랜덤 10문제 출제 프로그램
		//- 횟수니까 for 사용
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			
			int a = r.nextInt(8)+2;
			int b = r.nextInt(9)+1;
			
			System.out.println(a + " X " + b + " = ");
			
			int user = sc.nextInt();
			
			if(a*b == user) {
				System.out.println("정답");
			}
			else 
				System.out.println("오답");

	  }		
		sc.close();
	}

}