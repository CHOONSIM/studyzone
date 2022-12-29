package data;
import java.lang.*;

public class Test09 {
	public static void main(String[] args) {
		//목표 : 연산에 실수가 포함된다면 달라지는 것은 무엇인가?
		
		//예제 : 평균 구하기
		int korean = 70;
		int english = 75;
		
		int total = korean + english;
		int average = total / 2;
		
		System.out.println(total);
		System.out.println(average);
		
	}

}
