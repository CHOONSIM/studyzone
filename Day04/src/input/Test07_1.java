package input;

public class Test07_1 {

	public static void main(String[] args) {
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
		
		//과제 풀이
		
		//입력 : 이름, 인원수, 예상기간(일), 여행갈 년도와 월 정보
				String name = "피카츄";
				int people = 1;
				int day = 1;
				int year = 2023;
				int month = 1;
				
				int pricePerUnit = 100000;
				
				//처리
				int total = people * day * pricePerUnit;
				
				//윤년 할인
				//boolean leap = 4의 배수 && !100의 배수 || 400의 배수;
				boolean leap = year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0;
				
				//int leapRate = 0 or 5;
				int leapRate;
				if(leap) {
					leapRate = 5;
				}
				else {
					leapRate = 0;
				}
				
				//계절별 할인
				//int seasonRate = 10% or 5% or 30% or 20%;
				int seasonRate;
				if(month == 3 || month == 4 || month == 5) {//봄
					seasonRate = 10;
				}
				else if(month == 6 || month == 7 || month == 8) {//여름
					seasonRate = 5;
				}
				else if(month == 9 || month == 10 || month == 11) {//가을
					seasonRate = 30;
				}
				else {
					seasonRate = 20;
				}
				
				//할인 금액
				int rate = leapRate + seasonRate;
				//int discountPrice = 총금액 * 할인율 / 100;
				int discountPrice = total * rate / 100;
				
				//최종 금액
				int result = total - discountPrice;
				
				//출력
				System.out.println(name+"님의 예상 견적서는 다음과 같습니다");
				System.out.println();
				System.out.println("여행 예정 : "+year+"년 "+month+"월");
				System.out.println("여행 인원수 : "+people+"명");
				System.out.println("여행 기간 : "+day+"일");
				System.out.println();
				System.out.println("계절 할인 : "+seasonRate+"%");
				if(leap) {
					System.out.println("윤년 할인 : "+leapRate+"%");
				}
				System.out.println();
				System.out.println("총 금액 : "+total+"원");
				System.out.println("할인 금액 : "+discountPrice+"원");
				System.out.println("견적 금액 : "+result+"원");
				System.out.println();
				System.out.println("<버튼을 눌러 예약 사이트로 이동해주세요>");
	}

}
