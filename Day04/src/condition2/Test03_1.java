package condition2;
//import java.lang.*;
public class Test03_1 {
	public static void main(String[] args) {
		
		//문제 풀이
		
		//입력
		int birth = 20001201;
		
		int card = 500;
		
		//처리
		//int price = card + 1250 / 720 / 450 / 0;
		int price = card;
		int year = birth / 10000;
		int age = 2023 - year + 1;
		
		if(age <= 7 || age >= 65) {//어르신 & 영유아
			//price = price + 0;
			price += 0;//복합 대입 연산
		}
		else if(age >= 20) {//성인
			price += 1250;
		}
		else if(age >= 14) {//청소년
			price += 720;
		}
		else {//어린이
			price += 450;
		}
		
		//출력
		System.out.println("당신의 나이는 다음과 같습니다");
		System.out.println(age);
		System.out.println("결제 금액은 다음과 같습니다");
		System.out.println(price);
	}
}
