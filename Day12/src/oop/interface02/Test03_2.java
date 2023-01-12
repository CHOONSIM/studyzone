package oop.interface02;

public class Test03_2 {
	public static void main(String[] args) {
		
		//Calculator를 사용한 연산
		
		//Lamda
		
		Calculator c = (left, right) -> left + right;
		
		System.out.println(c.process(10,20));
	}

}
