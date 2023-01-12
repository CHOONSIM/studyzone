package oop.interface02;

public class Test01 {

	public static void main(String[] args) {
		
		//(원칙) 인터페이스는 객체 생성이 불가능하다.
		//(예외) 추상메소드가 해결되면 생성이 가능하다(익명중첩 클래스)
		//anonymous inner class = 무명 클래스 = 익명 중첩 클래스
		// - 객체 생성 구문 뒤에 {}를 열고 클래스처럼 메소드를 재정의
		// - 일회성이므로 객체가 소멸하면 클래스도 소멸
		
		Button menu = new Button() {

			@Override
			public void push() {
				System.out.println("<메뉴 표시>");
			}
			
		};
		menu.push();
		
		Button exit = new Button() {

			@Override
			public void push() {
				System.out.println("종료");
				
			}
			
		};
		exit.push();
		
	

	}

}
