package api.util.calendar;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test03_1 {

	public static void main(String[] args) throws ParseException {
		try(Scanner sc = new Scanner(System.in);){
		
		System.out.print("날짜 입력 : ");
		String input = sc.next();
		
//		String 날짜 형식을 Date로 변환할 수 있다(SimpleDateFormat 고유기능
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date time = parser.parse(input);
		
		Calendar c = Calendar.getInstance();
		
//		기준 날짜로 변경(2023.06.13)
		c.setTime(time);
		
		c.add(Calendar.DATE, -100);
		
		Format f = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(f.format(c.getTime()));
		

	 }
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
