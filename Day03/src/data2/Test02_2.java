package data2;
import java.lang.*;
import java.util.Calendar;
public class Test02_2 {
	public static void main(String[] args) {
		//사용자의 출생년도 4자리를 이용해서 성인/미성년자를 판정하는 프로그램을 구현
		//2000년생 성인 여부를 판정해서 출력
		//성인은 한국식 나이로 20세 이상을 의미
		
		//과제풀이2
		
		//입력 - 출생년도
		int birth = 2000;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(year);
		
		//처리 - 나이 → 성인여부
		//나이 = 올해 - 출생년도 + 1
		int age = year - birth + 1;
		System.out.println(age);
		
		//boolean adult = birth >= 2003;
		boolean adult = age >= 20;
		
		//출력 - 성인여부
		System.out.println(adult);
		
	}
}