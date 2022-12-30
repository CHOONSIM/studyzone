package data2;
import java.lang.*;

public class Test03 {
	public static void main(String[] args) {
		//목표 : 청소년 여부를 판정하는 프로그램
		// -중1(14세) ~ 고3(19세) 까지를 청소년이라고 본다
		
		//입력
		int age = 12;
		
		//계산
		//boolean teen = 나이가 14이상 19살이하?
		//boolean teen1 = 14 <= age <= 19;  //error
		//boolean teen = 나이가 14세 이상이면서 나이가 19 이하
		//boolean teen = age >= 14 이면서 age <= 19;
		boolean teen = age >= 14 && age <= 19;
		
		//출력
		System.out.println(teen);
	}

}
