package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test05 {

	public static void main(String[] args) throws IOException {
		
//		객체 준비
		Student stu = new Student("아무개", 85);
		
//		파일 출력
		File target = new File("temp", "student.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer	= new BufferedOutputStream(stream);
		ObjectOutputStream mixer = new ObjectOutputStream(buffer);
		
		mixer.writeObject(stu);
		
		mixer.close();
		

	}

}
