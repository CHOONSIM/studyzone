package api.util.date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

public class Test03_1 {

	public static void main(String[] args) {

//		변환 기본 언어 설정
		Locale.setDefault(Locale.GERMANY);
		
		Date a = new Date();
		
		
//		SimpleDateFormat b = new SimpleDateFormat("yyyy년\sMM월\sdd일\sE");
//		System.out.println(b.format(a));
		
//		오버캐스팅
		Format b = new SimpleDateFormat("yyyy년 MM월 dd일 E");
		System.out.println(b.format(a));
	
		
		Format c = new SimpleDateFormat("a H시 m분");
		System.out.println(c.format(a));
		
//		LocalTime d = LocalTime.now();
//		System.out.println(d.getHour() + ":" + d.getMinute() +":" + d.getSecond());
		Format d = new SimpleDateFormat("HH:mm:ss");
		System.out.println(d.format(a));
		
		
		Format e = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		System.out.println(e.format(a));

	}

}
