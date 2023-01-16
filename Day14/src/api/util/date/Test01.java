package api.util.date;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Test01 {

	public static void main(String[] args) {
		
		//프로그래밍에서는 날짜를 어떻게 관리하는가?
		
		// 1.System.currentTimeMillis()
		// - 측정용 시간
		// - 1970년 1월 1일 0시 0분 0초(기준시) 부터 지금까지 흘러온 밀리초(ms)
		
		long a = 1970 + System.currentTimeMillis() / 365 / 24 / 60 / 60 / 1000;
		System.out.println("a = " + a);
		
		
		// 2. java.util.date
		// - 최초로 등장한 시간 클래스
		// - 1900년을 기준으로 하므로 현재는 버려진 기능이 많음
		
		Date b = new Date();
		System.out.println("b = " + b);
		
		Date c = new Date(2023, 1, 16);  //사용 X 년도에 1900을 더해줌, 월은 0부터 시작
		System.out.println("c = " + c);
		
		
		// 3. java.util.calendar
		// - Date를 개선한 클래스
		// - 생성 대행 방식을 사용
		// - 날짜 계산에 특화
		Calendar d = Calendar.getInstance();
		System.out.println("d = " + d);
		
		d.set(2023, 5, 13);             //임의 설정  월 -1 (0부터)
		System.out.println(d.getTime());
		
		
		// 4. java.time 패키지
		// - 날짜만, 시간만, 날짜와 시간을 같이 쓰고 싶은 경우에 맞게 구성
		// - 월도 일반적인 방식으로 설정 가능
		LocalDate f = LocalDate.now();  //현재 시간
		LocalDate g = LocalDate.of(2023, 1, 16);
		
		System.out.println("f = " + f);
		System.out.println("g = " + g);

	}

}
