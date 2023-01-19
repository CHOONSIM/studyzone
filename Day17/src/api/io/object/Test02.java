package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
//		객체 입력
		File target = new File("temp", "object.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream combine = new ObjectInputStream(buffer);
		
		Date d = (Date) combine.readObject();		//다운캐스팅(복원)
		
		combine.close();
		
		Format f = new SimpleDateFormat("y년 M월 d일 E H시 m분 s초");
		System.out.println(f.format(d));

	}

}
