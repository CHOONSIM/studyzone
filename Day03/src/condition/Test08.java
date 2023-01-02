package condition;
import java.lang.*;

public class Test08 {
	public static void main(String[] args) {
		//KH 여행사는 무조건 1명 1박에 10만원이라는 슬로건으로 영업을 하고 있습니다.
		//추가로 여름 여행객을 유치하기 위해 다음과 같은 이벤트를 하기로 결정했습니다
		//여름(6,7,8월)에 여행가는 사람은 무조건 이용요금 25% 할인
		//다음 정보가 입력값으로 주어졌을 때 예상 여행 경비를 계산하여 출력하도록 프로그래밍하세요
		//인원 수(명)
		//여행 기간(일)
		//여행 계획중인 달(1월~12월 사이)
		
		//내 풀이
		
		//입력
		int price = 100000;
		int Dc = 25;
		int people = 1;
		int day = 1;
		int month = 5;
		
		//처리
		boolean summer = month > 5 && 9 > month;
				
		//출력
		if(summer) {
			System.out.println(price * (100-Dc) / 100 * day * people + "원 입니다." );
		}
		else {
			System.out.println(price * day * people + "원 입니다.");
		}
	 
	}
}