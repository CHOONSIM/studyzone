package api.lang.etc;

import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		
		//Math클래스
		// - 생성자 없음(아예 생성이 불가 / 미리 생성해두었거나 대행해주는 경우)
		// - 이 클래스는 모든 필드와 메소드가 static이므로 첫 번째 경우라 볼 수 있다.
		// - 아무데서나 편하게 부를 수 있는 일회용 계산 클래스
		
		// Math a = new Math();
		
		System.out.println(Math.PI); //원주율
		System.out.println(Math.E); //자연지수
		
		System.out.println(Math.round(1.5)); //반올림
		System.out.println(Math.floor(1.5)); //버림
		System.out.println(Math.ceil(1.5)); //올림
		
		System.out.println(Math.abs(50 - 20));  //절댓값
		System.out.println(Math.abs(20 - 50));
		
		Random r = new Random();
		int a = r.nextInt(6) + 1;
		int b = r.nextInt(6) + 1;
		System.out.println("a = " + a + ", b = " + b);
		System.out.println("max = " + Math.max(a, b) + ", b =" + Math.min(a, b));
		
		System.out.println(Math.pow(2, 10)); // 2의 10제곱

	}

}
