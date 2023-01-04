package random;

import java.util.Random;

public class Test04_1 {
	public static void main(String[] args) {
		
		//경품 추첨 확률은 다음과 같습니다.
		// - 강남 아파트 : 1%
		// - 테슬라 : 3%
		// - 다음 기회에 : 96%
		// 확률에 따라 추첨 결과 프로그램 구현
		
		//문제 풀이
		
		
		
		
		//처리
		Random r = new Random();
		
		int choice = r.nextInt(100)+1;
		System.out.println("choice = " + choice);
		
		String item;
		if(choice < 1) {
			item = "강남 아파트";
		}
		else if(choice <4) {
			item = "테슬라";
		}
		else {
			item = "다음 기회에";
		}
		
		//출력
		System.out.println("추첨 결과 : " + item);
		
	}
}
