package oop.interface02;

public class Test03_1 {
	public static void main(String[] args) {
		
		//Calculator를 사용한 연산
		
		//Lamda
		
		Calculator c = (left, right) -> {
				return left + right;
		};
		
		System.out.println(c.process(10,20));
	}

}
