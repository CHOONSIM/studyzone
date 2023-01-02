package data3;
import java.lang.*;

public class Test02 {
	public static void main(String[] args) {
		
		//String(문자열) (한글자에 2Byte)
		
		//문자열은 참조형 데이터 (reference type)이다
		//반대되는 표현은 원시형 데이터 (primitive type)이다
		//원시형 데이터는 간단하게 사용하는 크기가 정해진 데이터를 말한다( 총 8가지)
		// -참조형은 주문제작형태이므로 크기를 알 수 없다.
		// -참조형은 주문제작할 정도로 복잡하므로 참조변수(리모컨)가 존재
		// -참조변수를 이용하여 대상의 기능을 사용할 수 있다.
		// -더하기는 예외적으로 가능하다.(연결하기 위한 용도)

		String a = "hello";
		System.out.println(a);
		
		String b = "asdasdasdasda";
		System.out.println(b);
		
		System.out.println(a.length()); // a의 length 버튼을 눌러 글자수 구하기
		System.out.println(b.length());
		
		System.out.println("a = " + a);
	}

}
