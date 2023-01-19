package api.io.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) throws IOException {
		
//		문자열을 편법으로 바이트 변환 후 출력
		
		String text = "hello 안녕하세요";
		
		File target = new File("temp","string.kh");
		FileOutputStream stream = new FileOutputStream(target);
		
		byte[] b = text.getBytes();
		
		stream.write(b);
		
		stream.close();
		

	}

}
