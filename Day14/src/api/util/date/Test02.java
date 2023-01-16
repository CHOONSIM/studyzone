package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test02 {

	public static void main(String[] args) {

		//Date
		// - 현재 시각을 원하는 방식으로 출력하는데 주로 사용
		// - 포맷 설정을 클래스를 이용하여 변환하여 출력(java.text.SimpleDateFormat)
		
		Date a = new Date();
		System.out.println("a = " + a);
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f.format(a));
		

	}

}
