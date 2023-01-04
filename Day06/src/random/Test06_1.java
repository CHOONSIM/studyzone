package random;

import java.util.Random;
import java.util.Scanner;

public class Test06_1 {
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
		
		//1. 정답 출제(1~1000, 1~1000개)
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int answer = r.nextInt(1000)+1;
		System.out.println("answer = "+ answer);
		
		int count = 0;
		
		while(true) {
		//2. 정답 맞추기
		System.out.println("입력 = " );
		int user = sc.nextInt();
		
		 count++; //입력을 몇번 했냐
		
		if(answer> user) {  //정답이 입력값보다 클 때
			System.out.println("업");
			//count++;  업이 몇번이냐
		}
		else if(answer < user) {  //정답이 입력값보다 작을 때
			System.out.println("다운");
			//count++; 다운이 몇번이냐
		}
		else {   //나머지 정답과 입력값이 같을 때
			System.out.println("정답");
			break;
		 }
		}
		sc.close();
		System.out.println("총" + count + "번 만에 정답입니다.");
	}

}
