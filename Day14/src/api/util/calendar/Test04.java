package api.util.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		
//		2023년 중 하루 추첨
		
		Calendar c = Calendar.getInstance();
		
//		월 : 1월 ~ 12월 중 설정(0~11)
//		일 : 1일 ~ 31일 중 설정
		Random r = new Random();
		int month = r.nextInt(12) + 1;
		c.set(Calendar.YEAR, 2023);	//연도만 교체
		c.set(Calendar.MONTH, month-1); //월만 교체
		
		int max = c.getActualMaximum(Calendar.DATE);  //실제 일 수
		
		int date = r.nextInt(max) + 1;
		
		c.set(Calendar.DATE, date);
		
		Format f = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(f.format(c.getTime()));
		
		
	}

}
