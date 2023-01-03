package condition3;

public class Test03_4 {
	public static void main(String[] args) {
		//입력한 연/월에 해당하는 달의 일자수 구하기
		
		//입력
		int year = 2024;
		int month = 2;
		
		//처리
		//(참고) Java 13 부터는 switch의 결과를 변수에 저장할 수 있다
		//- 단, Lambda 식을 써야 한다
		boolean leap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		int day = switch(month) {
		case 2 -> leap ? 29 : 28;
		case 1, 3, 5, 7, 8, 10, 12 -> 31;
		default -> 30;
		};
		
		//출력
		System.out.println(year+"년 "+month+"월은 "+day+"일까지 있어요");
		
	}
}