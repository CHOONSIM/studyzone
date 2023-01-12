package oop.interface02;

public class Test02 {

	public static void main(String[] args) {
		//Lamda(람다) ?
		// - 추론을 할 수 있도록 축약한 식을 말함
		// - 안써도 되는 코드를 생략한 것
		// - 함수형 프로그래밍을 위해 자바에서 제공하는 방법
		
		//반드시 지켜져야 하는 조건
		// 1. 인터페이스 일 것
		// 2. 메소드를 1개만 갖고 있을 것(함수형 인터페이스)
		
		//등장 시기 : Java 8+
		
		// ->  : 람다 (추론식) 
		
		
		
//		Button menu = new Button() {
//
//			@Override
//			public void push() {
//				System.out.println("<메뉴 표시>");
//			}
//			
//		};
//		menu.push();
		
		
		Button menu = () -> {
				System.out.println("<메뉴 표시>");
		};
		menu.push();
		
		Button exit = () -> System.out.println("종료"); 

	}

}
