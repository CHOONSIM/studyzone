package oop.modifier05;

import oop.modifier04.Car;

public class Test01 {
	public static void main(String[] args) {
		
		//자바에서 접근제한이 없으면 패키지 단위로 처리
		//c1.name = "소나타";
		
//		c1.setName("소나타");
//		c1.setPrice(20000000);
		
		Car c1 = new Car("소나타", 20000000);
		
		c1.output();
	}

}
