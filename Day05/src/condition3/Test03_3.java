package condition3;

public class Test03_3 {
	public static void main(String[] args) {
		//입력한 연/월에 해당하는 달의 일자수 구하기
		
		//입력
		int year = 2024;
		int month = 2;
		
		//처리
		//int day = 31 or 30 or 29 or 28;
		int day;
		
		//(주의) case에 콤마를 작성할 수 있는 버전은 자바 12부터이다
		switch(month) {
		case 2: 
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				day = 29;
			}
			else {
				day = 28;
			}
			break;
		case 1, 3, 5, 7, 8, 10, 12: 
			day = 31; break;
		default: day = 30; break;
		}
		
		//출력
		System.out.println(year+"년 "+month+"월은 "+day+"일까지 있어요");
		
	}
}