package random;

import java.util.Random;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] main) {
		
		//랜덤으로 10개의 구구단 문제를 출제하고, 사용자가 이를 풀 수 있도록 구현
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int n = r.nextInt(10)+1; 
		int n1 = r.nextInt(10)+1;
		int respone; //답입력값
		int answer; //정답
		int i;
		
		System.out.println(n);
		System.out.println(n1);
		

		
		sc.close();
		
		
	}

}
