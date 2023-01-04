package loop;

import java.util.Scanner;

public class Test12 {
	public static void main(String[] args) {
		//사용자가 원하는 구구단을 출력하는 프로그램을 구현하세요

		//(+추가) 다 만드셨다면 정답 부분을 사용자가 입력하게 만들어 정답/오답 판정이 가능하게 하세요

		//괄호 친 부분은 사용자가 입력하는 부분입니다
		//원하는 구구단 : (5)

		//5 x 1 = (5)
		//정답!
		//5 x 2 = (9)
		//오답!
		//...
		//5 x 9 = (45)
		//정답!

		//정답 개수 : 2
		
		Scanner sc = new Scanner(System.in);
		
		int problem = 0;
		int answer = 0;
		
		System.out.println("원하는 구구단을 입력");
		int n = sc.nextInt();
		
		for(int i = 0; i <10; i ++) {
			//구구단 처리
			
		}
	}

}
