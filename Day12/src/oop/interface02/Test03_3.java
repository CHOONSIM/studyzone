package oop.interface02;

public class Test03_3 {
	public static void main(String[] args) {
		
		//Calculator를 사용한 연산
		
		//Lamda
		
		Calculator plus = (left, right) -> left + right;
		Calculator multi = (left, right) -> left * right;
		
		System.out.println(
				plus.process(1,multi.process(2,3))  //1+2*3
						);
		
	}

}
