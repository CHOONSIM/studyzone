package loop;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		//목표 : 반복문에서 입력받기
		//(주의) 반복문 내에서 도구 생성 및 close금지
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i < 10; i++) {
			
			System.out.println("정수 입력");
			int n = sc.nextInt();
			System.out.println("n = " + n);
		}
		
		//System.out.println("정수 입력");
		//int n = sc.nextInt();
		//System.out.println("n = " + n);
		
		//System.out.println("정수 입력");
		//int n2 = sc.nextInt();
		//System.out.println("n = " + n);
		
		sc.close();
		
		

	}

}
