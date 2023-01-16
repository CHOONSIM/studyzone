package api.time;

import java.time.LocalDate;
import java.time.Period;

public class Teat01 {

	public static void main(String[] args) {
		
//		Java 8+ 에서 나온 java.time 패키지 사용법
//		- 명령이 간단해짐
//		- 날짜와 시간이 분리
//		- 출력과 계산이 모두 용이(새로운 방식)
//		- SimpleDateFormat 사용불가
		
//		ex : 날짜만 사용(LocalDate)
		LocalDate a1 = LocalDate.now();
		System.out.println(a1.getYear());
		System.out.println(a1.getMonth());
		System.out.println(a1.getMonthValue()); //숫자만 표시
		System.out.println(a1.getDayOfMonth());
		System.out.println(a1.getDayOfWeek());
		
		LocalDate a2 = LocalDate.of(2023, 6, 13);
		System.out.println(a2);
		
		LocalDate a3 = LocalDate.parse("2023-06-13");
		System.out.println(a3);
		
//		시간 차이 계산
		Period period = Period.between(a1, a3);
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
		

	}

}
