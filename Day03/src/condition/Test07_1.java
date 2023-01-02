package condition;
import java.lang.*;
public class Test07_1 {
	public static void main(String[] args) {
		//과속단속 카메라 프로그램
		
		//과제 풀이
		
		//입력
		int speed = 70;
		
		int limit = 50;//제한속도(km)
		int term = 10;//속도구간
		int termPrice = 10000;//구간요금
		int basePrice = 30000;//기본벌금
		
		//처리
		//int fine = 0 or 계산된 벌금;
		int fine;
		
		if(speed <= limit) {//과속이 아니면
			fine = 0;
		}
		else {//과속이라면
			//int advance = 10km당 10000원;
			int advance = (speed - limit) / term * termPrice;
			fine = basePrice + advance;
		}
		
		//출력
		System.out.println("지금 지나간 차의 벌금");
		System.out.println(fine);
		
	}
}