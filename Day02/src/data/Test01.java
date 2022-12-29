package data;
import java.lang.*;

public class Test01 {
	public static void main(String[] args) {
		//데이터(Data)
		//- 계산에 쓰이는 값
		//- 숫자는 크게 소수점 유무로 갈린다(있으면 실수,없으면 정수)
		
		//정보(Information) 
		//- 계산으로 만들어진 의미있는 결과물(ex:음식)
		
		System.out.println(10); //정수 10을 출력
		System.out.println("10"); //글자 10을 출력
		System.out.println(1.4); //실수 1.4를 출력
		
		System.out.println(10 + 1.4); //정수와 실수를 계산하면 실수가 나옴
		System.out.println(10 + 20); //정수와 정수를 계산하면 정수가 나옴
		
		System.out.println(10 / 3); //정수와 정수를 계산하여 3이 출력
		System.out.println(10 / 3.0); //정수와 실수를 계산하여 3.3333..출력
		
	}

}
