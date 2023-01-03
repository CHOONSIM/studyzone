package condition3;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// - 사용자에게 연도와 월을 입력받습니다
		// - 해당하는 월의 날짜수를 구하여 출력
		// - 윤년인 경우 2월이 29일까지 있음
		
		//int year = 2023;
		//int month = 1;
		
		//내 풀이
		
		int day;
		int leapDay;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("년도를 입력하시오");
		int year = sc.nextInt();
		
		System.out.println("월을 입력하시오");
		int month = sc.nextInt();
		
		sc.close();
		
		//윤년

		boolean is4 = year % 4 ==0;
		boolean is100 = year % 100 ==0;
		boolean is400 = year % 400 ==0;
		boolean leap = is4 && !is100 || is400;
		
		if (leap) {
			leapDay = 29;
		}
		
		switch(month) {
		case 2:
			if(leap) {
				day = 29;
			}
			else {
				day = 28;
			}
			break;
			
		case 1 , 3 , 5 , 7 , 8 , 10 , 12:
			day = 31; 
		break;
		default: day = 30;
		}
		
		System.out.println(year + "년" + month + "월은" + day + "까지 있습니다.");
	}

}
