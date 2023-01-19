package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class test06 {

	public static void main(String[] args) throws IOException, Exception {


		File target = new File("temp", "student.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream combine = new ObjectInputStream(buffer);
		
		Student stu = (Student) combine.readObject();
		
		combine.close();
		
		System.out.println(stu);
		
		

	}

}
