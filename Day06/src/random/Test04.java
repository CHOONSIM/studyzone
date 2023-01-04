package random;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		
		//경품 추첨 확률은 다음과 같습니다.
		// - 강남 아파트 : 1%
		// - 테슬라 : 3%
		// - 다음 기회에 : 96%
		// 확률에 따라 추첨 결과 프로그램 구현
		
		//내 풀이
		
		Random r = new Random();
		
		int price = r.nextInt(99);
		System.out.println(price);
		if(price == 0) {
			System.out.println("강남 아파트 당첨");
		}
		else if(price >0 && price <=3) {
			System.out.println("테슬라 당첨");
		}
		else 
		System.out.println("다음 기회에");
	  
		
	}
}
