package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test03 {

	public static void main(String[] args) throws IOException {
		
//		문자열은 출력 스트림을 따로 쓴다
//		- Writer와 Reader를 상속받은 클래스들을 조합하여 사용
//		- 버퍼 성능 조절을 위해 BufferedWriter 조합
//		- 다양한 출력 형태를 위해 PrintWriter 조합 (분해도구가 아님)
		
		File target = new File("temp", "string2.kh");
		FileWriter fw = new FileWriter(target);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);		//read 없음
		
		pw.println("hello 안녕하세요");
		pw.println("hello!");
		pw.println(100);
		
		pw.close();
		
		
	}

}
