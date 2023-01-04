package random;

import java.util.Random;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
//		업다운 게임
//
//		숫자를 하나 정해두고 이를 맞추는 게임을 업다운 게임이라고 합니다.
//
//		프로그램이 랜덤으로 1에서 1000 사이의 숫자를 하나 정합니다.
//		사용자가 범위 내에서 숫자를 입력합니다.
//		프로그램은 사용자가 입력한 값과 정답을 비교해서 업, 다운, 정답 세 개중 하나를 알려줍니다.
//		업은 정답이 입력값보다 크다는 의미입니다.
//		다운은 정답이 입력값보다 작다는 의미입니다.
//		정답은 정답과 입력값이 같은 경우를 말하며, 게임이 종료되어야 합니다.
//		업다운 게임을 구현하시고 정답을 맞추면 몇 번 만에 맞췄는지 계산해서 출력해주세요.
		
		
		//내 풀이
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("1~1000 사이의 숫자를 입력하세요.");
		
		int total = 0;
		int count = 0;
		
		
		int num = r.nextInt(1000)+1;
		System.out.println(num);
		
		for(int i=0; i < 1000; i++) {
		int user =sc.nextInt();
		if(num > user) {
			System.out.println("업");
		}
		else if(num < user) {
			System.out.println("다운");
		}
		else
			System.out.println("정답");
		    
		}
		sc.close();
	}

}
