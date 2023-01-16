package api.time;

import java.text.DecimalFormat;
import java.text.Format;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Test02_1 {

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
		
//		(추가) java.text.DecomalFormat 클래스를 사용하여 숫자 형식을 정의
//		- # 은 해당 자리가 있으면 출력, 없으면 비워두는 형식
//		- 0 은 해당 자리가 있으면 출력, 없으면 0으로 출력하는 형식
//		- , 는 그룹 표시 형식이며 패턴이 자동으로 설정됨
//		- . 은 소주점 표시 형식
		
		Format f = new DecimalFormat("#,##0.00원");
		System.out.println(f.format(fee));

	}

}
