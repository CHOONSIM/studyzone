package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test05 {

	public static void main(String[] args) throws IOException {
		
//		Test03 프로그램의 성능 개선
//		- 버퍼(buffer)를 사용한 대량 복사
		
		File target = new File("temp", "single.kh");
		File newtarget = new File("temp", "copy.kh");
		
		FileInputStream inputStream = new FileInputStream(target);
		FileOutputStream outputStream = new FileOutputStream(newtarget);
		
		byte[] buffer = new byte[5];
		
		while(true) {
			int size = inputStream.read(buffer);
			if(size == -1) break;
			outputStream.write(buffer,0,size);			//0부터 size 갯수만큼 내보내라
		}
		
		inputStream.close();
		outputStream.close();
		
	}

}
