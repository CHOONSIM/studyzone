package api.util.random;

import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		
//		Random 클래스
//		- seed : 랜덤을 계산하기 위한 시작값(미설정 시 시간으 고려하여 설정)
		
		Random r1 = new Random();		//시드 미설정
		Random r2 = new Random(1L);		//시드 설정
		Random r3 = new Random(System.currentTimeMillis()); //r1과 원리가 같음
		
		System.out.println("r1 = " + r1.nextInt());
		System.out.println("r2 = " + r2.nextInt());
		System.out.println("r3 = " + r3.nextInt());

	}

}
