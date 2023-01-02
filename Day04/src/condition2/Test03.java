package condition2;
import java.lang.*;

public class Test03 {
	public static void main(String[] args) {
		
		//지하철 이용요금 계산
		
		//어르신(65세~) - 무료
		//성인(20세~65세) - 1250원
		//청소년(14세~19세) - 720원
		//어린이(8세~13세) - 450원
		//영유아(~7세) - 무료
		//카드보증금이 500원일 때, 출생년도 4자리에 따라 지하철 이용요금을 구하여 출력
		
		int birth = 2013;
		int todaysYear = 2023;
		int card = 500;
		int adult = 1250;
		int teen = 720;
		int child = 450;
		int age = todaysYear - birth;
		
		
		
		if(age >= 65) {
			System.out.println(card + " 원 입니다.");
		}
		else if(age >= 20) {
			System.out.println(card + adult + " 원 입니다.");
		}
		else if(age >= 14) {
			System.out.println(card + teen + " 원 입니다.");
		}
		else if(age >= 8) {
			System.out.println(card + child + " 원 입니다.");
		}
		else {
			System.out.println(card + " 원 입니다.");
		}
		
		
	}

}
