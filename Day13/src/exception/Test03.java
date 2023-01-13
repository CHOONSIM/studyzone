package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		// ex) 1/n 계산기
		
		//문제가 되는 상황
		// 1. 실수 입력 시  java.util.InputMismatchException 발생
		// 2. 한글 입력 시 java.util.InputMismatchException 발생
		// 3. 영어 입력 시 java.util.InputMismatchException 발생
		// 4. 인원이 0 일 경우 java.lang.ArithmeticException 발생
		// 5. 너무 큰 숫자일 경우 java.util.InputMismatchException 발생
		// 결론적으로 이 프로그램에서 파악한 문제는 2종류이다.
		// - 1, 2, 3, 5는 입력이 잘못된 경울
		// - 4는 나눗셈이 잘못된 경우
		
		//문제점
		// - 오류가 정말 2개 뿐인것인가	
		// - RuntimeException 상속	ArithmeticException		InputMismatchException
		// - 장담할 수 없으므로 "통합처리"하는 방법으로 변경 (업캐스팅)
		
		
		try { //문제가 발생하리라고 예산되는 지역(플랜A)
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액 : ");
		int money = sc.nextInt();
		
		System.out.print("인원 : ");
		int people = sc.nextInt();
		
		sc.close();
		
		int result = money / people;
		int remain = money % people;
		
		System.out.println("1인당 "+result+"원");
		System.out.println("짜투리 "+remain+"원");
		}
//		catch(RuntimeException e) {
		catch(Exception e) {  //앞으로 모든 예외를 통합처리 할때
//		catch(Throwable e) {  //오류와 예외        Error : 오류
//		catch(Object e) { //error
			System.err.println("오류가 발생했습니다.");
		}
		
		}

}