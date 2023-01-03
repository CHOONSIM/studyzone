package loop;

import java.util.Scanner;

public class Test09_1 {

	public static void main(String[] args) {
		
//		소수 찾기 프로그램
//		소수는 자기자신과 1을 제외한 나머지 나눗셈이 불가능한 숫자를 말합니다
//		예를들어 2,3,5,7과 같은 숫자를 말합니다.
//      사용자가 어떤 숫자를 입력했을 때, 이 숫자가 소수인지 아닌지 출력
		
		//문제 풀이
		
		//입력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int number = sc.nextInt();
		
		int count = 0;
		
		for(int i=1; i<=number; i++) {
			if(number % 1 ==0) {
				System.out.println(number % i);
				count++;
			}
			
		}
		System.out.println("count = " + count);
		
		//출력
		if(count == 2) {
			System.out.println(number + "은 소수입니다.");
		}
		else {
			System.out.println(number + "은 소수가 아닙니다.");
		}
		
	}

}
