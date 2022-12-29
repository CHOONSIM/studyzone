package data;
import java.lang.*;

public class Test8_1 {
	public static void main(String[] args) {
		
		//1+1 행사상품 구매금액 계산
		
		//입력
				int count = 9;
				int price = 1200;
				
				//계산
				int free = count / 2;
				//int fare = (count+1) / 2;
				int fare = count - free;
				int result = price * fare;
				
				//출력
				System.out.println(free);
				System.out.println(result);
		
	}

}
