package input;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		//이전에 만들었던 KH 여행사 프로모션 프로그램의 기능을 개선할 계획입니다.

		//모든 계절에 따른 할인율은 다음과 같습니다
		//봄 : 10%
		//여름 : 5%
		//가을 : 30%
		//겨울 : 20%
		//윤년일 경우 5% 추가 할인을 받습니다
		//사용자에게 이름, 인원수, 여행예상일자, 여행갈 년도와 월 정보를 각각 입력받아 다음과 같은 출력 결과가 나올 수 있도록 구현하세요
		
		//1인 1일 10만원 

		//홍길동님의 예상 견적서는 다음과 같습니다

		//여행 예정 : 2024년 1월
		//여행 인원수 : 3명
		//여행 기간 : 10일
		//계절 할인 : 10%
		//윤년 할인 : 5%

		//총 금액 : 3000000원
		//할인 금액 : 450000원
		//견적 금액 : 2550000원

		//<버튼을 눌러 예약 사이트로 이동해주세요>
		
		//내 풀이
		
		int oneDayCost = 100000;
		int springDc1 = 10;
		int summerDc1 = 5;
		int fallDc1 = 30;
		int winterDc1 = 20;
		int moonDc = 5;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		
		System.out.println("인원 수를 입력하세요.");
		int people = sc.nextInt();
		
		System.out.println("여행예상일자를 입력하세요.");
		int day = sc.nextInt();
		
		System.out.println("여행갈 년도를 입력하세요.");
		int year = sc.nextInt();
		
		System.out.println("여행갈 월을 입력하세요.");
		int month = sc.nextInt();
		
		sc.close();
		
    //윤년
    
		boolean is4 = year % 4 ==0;
		boolean is100 = year % 100 ==0;
		boolean is400 = year % 400 ==0;
		boolean leap = is4 && !is100 || is400;
		
		if (leap) {
			moonDc =5;
		}
		
    //계절할인율
    
		int discount;
		
		if(month == 1 || month == 2 || month == 12) {
			discount = winterDc1;
		}
		else if(month >= 9) {
			discount = fallDc1;
		}
		else if(month >= 6) {
			discount = summerDc1;
		}
		else { 
			discount = springDc1;
	      }
    
		int price1 = oneDayCost * day * people;
		int discount1 = price1 * (discount + moonDc) / 100;
		int totalCost = price1 - discount1;
		
		System.out.println(name + "님의 예상 견적서는 다음과 같습니다.");
		System.out.println("여행예정 : " + year + "년" + month + "월");
		System.out.println("여행 인원수 : " + people + "명");
		System.out.println("여행 기간 : " + day + "일");
		System.out.println("계정 할인 : " + discount + "% 할인 됩니다.");
		if(leap) {
			System.out.println("윤년 할인 : " + moonDc + "% 할인 됩니다.");
		}
		System.out.println("총 금액 : " + price1 + "원 입니다.");
		System.out.println("할인 금액 : " + discount1 + "원 입니다.");
		System.out.println("견적 금액 : " + totalCost + "원 입니다.");
		System.out.println("<버튼을 눌러 예약 사이트로 이동해주세요.>");

	}

}