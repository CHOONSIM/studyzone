package api.util.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Test04_3 {

	public static void main(String[] args) {
		

		Calendar c = Calendar.getInstance();
		Random r = new Random();
		
		while(true) {

			int month = r.nextInt(3) + 6;
			c.set(Calendar.YEAR, 2023);
			c.set(Calendar.MONTH, month-1); 
			
			int max = c.getActualMaximum(Calendar.DATE); 
			
			int date = r.nextInt(max) + 1;
			
			c.set(Calendar.DATE, date);
			
			Format f = new SimpleDateFormat("yyyy-MM-dd E");
			
//			요일을 구하는 방법
//			1. 숫자로 추출  (일요일 = 1요일)
//			2. 문자열로 추출
			
			int week = c.get(Calendar.DAY_OF_WEEK);
//			if(week == 1 || week == 7)
			if(week == Calendar.SUNDAY || week == Calendar.SATURDAY) {
				System.out.println(f.format(c.getTime()));
				break;
			}
		}	
	}

}
