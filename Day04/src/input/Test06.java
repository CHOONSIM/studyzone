package input;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		//목표 : 문자열 입력
		//- .next() 명령을 사용
		//- (주의) 띄어쓰기가 있으면 다른 입력으로 인식
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("닉네임을 입력");
		String nickname = sc.next();
		sc.close();
		
		System.out.println("닉네임 : " + nickname);

	}

}
