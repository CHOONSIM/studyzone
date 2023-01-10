package oop.keyword01;

public class Test01 {
	public static void main(String[] args) {
		
		//final 키워드
		// - 최초 이후의 작업을 금지하는 역할
		// - 변수는 할당 금지, 메소드는 재정의 금지, 클래스는 상속 금지
		
		//int a = 10;
		final int a = 10;
		
		//a = 20;
		//a = 30;
		
		System.out.println("a = " + a);
	}

}
