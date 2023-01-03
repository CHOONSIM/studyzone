package loop;

import java.util.Scanner;

public class Test11 {
	public static void main(String[] args) {
		
		//사용자에게 숫자를 5개 입력받아 입력 받은 숫자의 '평균'을 출력
		
		Scanner sc = new Scanner(System.in);
		int total = 0;
		
		
		for(int i=0; i <5; i++) {
			
			
			System.out.println("숫자입력");
			int n = sc.nextInt();
			total += n;
			
			//System.out.println("n = " + n);
			
		}
		sc.close();
		
		double average = (double)total / 5;
		//int average = total / 5; (정수)  
		System.out.println("총 합 :" + total);
		System.out.println("평균 :" + average);
		
	}

}
