package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test04 {

	public static void main(String[] args) throws IOException {
		
//		문자열 입력
//		- FileReader는 정해진 크기의 char만 읽을 수 있다.
//		- BufferedReader를 추가하면 줄단위 입력이 가능하게 한다
		
		File target = new File("temp", "string2.kh");
		FileReader fr = new FileReader(target);
		BufferedReader br = new BufferedReader(fr);
		
		
//		String line = br.readLine();		//한줄 읽음
//		System.out.println("line = "+line);
//		line = br.readLine();
//		System.out.println("line = "+line);
//		line = br.readLine();
//		System.out.println("line = "+line);
//		line = br.readLine();
//		System.out.println("line = "+line);  //null -> EOF
//		line = br.readLine();
		
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			System.out.println("line = "+line);
		}
		br.close();
		
		
	}

}
