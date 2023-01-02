package input;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// 목표 : 입력을 이용한 나이계산 문제
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 4자리 입력");
		int birth = sc.nextInt();
		sc.close();
		
		//처리
		int age = 2023 - birth + 1;
		
		//출력
		System.out.println("당신의 나이는 " + age + " 세 입니다.");

	}

}
