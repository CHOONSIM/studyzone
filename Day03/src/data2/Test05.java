package data2;
import java.lang.*;

public class Test05 {
	public static void main(String[] args) {
		//회사 이벤트 페이지 제작
		//출생년도 4자리 입력하게하고 출생년도가 3의 배수이거나 5의 배수라면
		//당첨 프로그램 처리
		//2001년생이 이벤트 당첨 조건에 해당 되는지 아닌지 판정하여 출력
		
		//입력
		int birthYear = 2001;
		
		//처리
		//birthYear == 3의 배수 or || birthYear == 5의 배수
		//boolean event1 = 3의 배수;
		//boolean event2 = 5의 배수;
		//boolean event = event1 or event2;
		
		boolean event1 = birthYear % 3 == 0;
		boolean event2 = birthYear % 5 == 0;
		boolean event = event1 || event2;
		
		//System.out.println(event1);	
		//System.out.println(event2);
		
		//출력
		System.out.println(event);
	}

}
