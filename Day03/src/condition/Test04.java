package condition;
import java.lang.*;

public class Test04 {
	public static void main(String[] args) {
		//목표 : 홀짝 프로그램 개선(분리된 조건을 그룹화)
		
		int n = 123;
		
		boolean even = n % 2 == 0;
		
		if(even) {
			System.out.println("짝수");
		}
		else {  //if가 거짓이면 실행
			System.out.println("홀수");
		}
	}

}
