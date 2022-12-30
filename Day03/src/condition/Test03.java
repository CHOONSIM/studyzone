package condition;
import java.lang.*;

public class Test03 {
	public static void main(String[] args) {
		//국밥집에서 국밥 한그릇이 7천원
		//65세 이상 어르신에게는 50% 할인 판매
		//손님의 나이가 주어지면 국밥 가격이 출력되도록 구현
		
		//입력
		int age = 65;
		int cost = 7000;
		int dc = 10;
		
		//처리
		boolean freeAge = age >= 65;
		
		//출력
		if(freeAge) {
			System.out.println(cost * (100 - dc) / 100  + " 원 입니다.");
		}
		if(!freeAge) {
			System.out.println(cost + " 원 입니다.");
		}
	}

}
