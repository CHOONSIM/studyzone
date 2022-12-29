package data;
import java.lang.*;

public class Test10 {
	public static void main(String[] args) {
		//목표 : 연산에 실수가 포함된다면 달라지는 것은 무엇인가?
		// - 실수가 한개라도 연산과정에 포함된다면 결과는 무조건 실수다.
		
		//예제 : 평균 구하기 , double : 실수
		double korean = 70.0;
		double english = 75.0;
		
		double total = korean + english;
		double average = total / 2;  //total = 실수 , 2 = 정수 -> average = 실수
		
		//int korean = 70.0;
		//int english = 75.0;
		
		//int total = korean + english;
		//double average = total / 2.0;
		
		System.out.println(total);
		System.out.println(average);
		
	}

}
