package data;
import java.lang.*;

public class Test14 {
	public static void main(String[] args) {
		//정수 : byte(1), short(2), int(4), long(8)
		//실수 : float(4), double(8)
		//(주의) : 실수는 어떠한 경우에도 정수보다 크다
		
		int a = 2100000000 + 2000000000; //범위 초과
		System.out.println(a);
		
		long b = 2200000000L; //long은  int와 구분하기 위해 L 표시를 붙임
		System.out.println(b);
		
		long c = 2100000000L + 2000000000L;
		System.out.println(c);
		
		double d = 3.14;
		float e = 3.14F; //float와 double을 구분하기 위해 f,F 표시를 붙임
		                 //float와 double은 저장구조가 다름
		System.out.println(d);
		System.out.println(e);
	}

}
