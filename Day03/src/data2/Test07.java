package data2;
import java.lang.*;

public class Test07 {
	public static void main(String[] args) {
		//윤년 계산기 만들기
		//윤년이란 실제 1년과 달력상의 1년의 차이 때문에 생기는 날짜를 메꾸기 위한 해입니다
		//실제 = 365.24..일 , 달력 = 365
		//윤년의 규칙은 다음과 같습니다.
		// 윤년에는 2월이 29일까지 있습니다(366일)
		//4의 배수면 해는 윤년으로 간주합니다.
		//100의 배수인 해는 4의 배수일지라도 윤년이 아닌 것으로 간주합니다
		//400의 배수인 해는 100의 배수일지라도 윤년으로 간주합니다
		//이 기준을 토대로 특정 연도가 윤년인지 아닌지 판정해서 출력
		
		//내 풀이
		
		//입력
		    //int year = 5;
		
		
		//처리
		//4의 배수는 윤년
		   //boolean X4 = year % 4 == 0;
		//System.out.println(X4);
		
		//100의 배수, 400의 배수
		   //boolean X100 = year % 100 == 0;
		   //boolean X400 = year % 400 == 0;
		//System.out.println(X100);
		//System.out.println(X400);
		
		//100의 배수인 해는 4의 배수일지라도 윤년이 아님
		   //boolean moon1 = X100 != X4;
		//400의 배수인 해는 100의 배수일지라도 윤년으로 간주
		   //boolean moon = X400 == X100;
		
		   //System.out.println(moon);
		
		
		
		//문제풀이
		
		//입력
		int year = 2022;
		
		//처리
		//1. 4의 배수면 윤년
		//2. 100의 배수면 1번이라도 윤년이 아님
		//3. 400의 배수면 2번이라도 윤년
		//4. 4의 배수이면서 100의 배수면 안되고 400의 배수면 윤년;
		boolean is4 = year % 4 ==0;
		boolean is100 = year % 100 == 0;
		boolean is400 = year % 400 == 0;
		
		//(참고) 논리에서 true와 같냐는 코드는 덧셈의 +0, 곱셈의 *1과 같은 코드(생략가능)
		//boolean leap = 4의 배수 && 100의 배수가 아님 || 400의 배수;
		//boolean leap = year 4 % == 0 && year % 100 != 0 || year % 400 == 0;
		
		//boolean leap = is4 == true && is100 == false || is400 == true;
		// is100 == false  ->  !is100 true가 아니면 (!는 부정)
		boolean leap = is4 && !is100 || is400;
		
		//출력
		System.out.println(leap);
		
		
		 
	}

}
