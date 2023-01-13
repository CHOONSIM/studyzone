package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		
		// ex) 1/n 계산기
		
		//문제점
		// 1. 개발자는 문제라고 생각하는데 자바는 문제가 아니라고 생각하는 경우
		// 2. 예외가 여러 종류가 발생하는데 구분할 수 있는 방법이 있는가?
		// 강제 예외 - 던진다(Throw)
		
		
		try {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액 : ");
		int money = sc.nextInt();
		if(money <= 0) {  //자바가 감지하지 못하는 예외상황
//			Exception ex = new Exception();
//			throw ex;
			throw new Exception();
		}
		
		System.out.print("인원 : ");
		int people = sc.nextInt();
		if(people < 0) {
			throw new Exception();
		}
		
		sc.close();
		
		int result = money / people;
		int remain = money % people;
		
		System.out.println("1인당 "+result+"원");
		System.out.println("짜투리 "+remain+"원");
		}

		catch(Exception e) {  

			System.err.println("오류가 발생했습니다.");
		}
		
		}

}


