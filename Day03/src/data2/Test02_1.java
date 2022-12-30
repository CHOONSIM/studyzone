package data2;
import java.lang.*;
import java.time.Year;

public class Test02_1 {
	public static void main (String[] args) {
		//사용자의 출생년도 4자리를 이용해서 성인/미성년자를 판정하는 프로그램을 구현
		//2000년생 성인 여부를 판정해서 출력
		//성인은 한국식 나이로 20세 이상을 의미
		
		
		//과제 풀이
		
		//입력
		   int birth = 2000;
		   int year = Year.now().getValue();
		   System.out.println(year);
		   
		//처리
		//나이 = 올해 - 출생년도 + 1
		   int age = 2022 - birth + 1;
		   System.out.println(age);
		   
		   boolean adult = age >= 20;
		
		//출력
		   System.out.println(adult);
		
	}

}
