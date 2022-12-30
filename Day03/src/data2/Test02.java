package data2;
import java.lang.*;

public class Test02 {
	public static void main (String[] args) {
		//사용자의 출생년도 4자리를 이용해서 성인/미성년자를 판정하는 프로그램을 구현
		//2000년생 성인 여부를 판정해서 출력
		//성인은 한국식 나이로 20세 이상을 의미
		
		//내 풀이
		
		//입력
		int birthYear = 2000;
		int nowYear = 2022; 
		int adultAge = 20;
		
		//처리
		int age = nowYear - birthYear + 1;
		System.out.println(age);
		boolean realAge = age >= adultAge;
		
		//출력
		System.out.println(realAge);
	}

}
