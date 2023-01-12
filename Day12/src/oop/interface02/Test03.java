package oop.interface02;

public class Test03 {
	public static void main(String[] args) {
		
		//Calculator를 사용한 연산
		Calculator c = new Calculator() {

			@Override
			public int process(int left, int right) {
				return left + right;
			}
			
		};
		
		System.out.println(c.process(10,20));
	}

}
