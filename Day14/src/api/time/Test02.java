package api.time;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("시작 시간:분 입력 = ");
		String t1 = sc.next();
		System.out.println("종료 시간:분 입력 = ");
		String t2 = sc.next();
		
		LocalTime start = LocalTime.parse(t1);
		LocalTime end = LocalTime.parse(t2);
		
		Duration duration = Duration.between(start,end);
		
		long minute = duration.getSeconds()/60L;
		System.out.println("이용 시간(분) : " + minute + "분");
		
		int hourFee = 1000;
		double minuteFee = hourFee / 60.0;
		long fee = (long)(minuteFee * minute); 
		System.out.println("사용 요금(원) : " + fee);

	}

}
