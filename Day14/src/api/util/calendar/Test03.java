package api.util.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test03 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		
		c.set(2023, 5, 13);
		
		c.add(Calendar.DATE, -100);
		
		Format f = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(f.format(c.getTime()));
		

	}

}
