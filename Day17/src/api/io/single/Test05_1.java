package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;

public class Test05_1 {

	public static void main(String[] args) throws IOException {
		
//		Test03 프로그램의 성능 개선
//		- 버퍼(buffer)를 사용한 대량 복사
//		- 컴퓨터는 2진수를 쓰므로 2진수로 만들 수 있는 숫자가 최적의 성능을 발휘
//		- 일반적으로 1024, 2048, 4096, 8192 중 하나를 쓴다
//		- 자바 표준은 8192
		
		File target = new File("temp", "single.kh");
		File newtarget = new File("temp", "copy.kh");
		
		FileInputStream inputStream = new FileInputStream(target);
		FileOutputStream outputStream = new FileOutputStream(newtarget);
		
		byte[] buffer = new byte[8192];
		
		long total = target.length();
		long count = 0L;
		Format f = new DecimalFormat("#,##0.00");	
		
		long start = System.currentTimeMillis();		//걸리는 시간
		
		while(true) {
			int size = inputStream.read(buffer);
			if(size == -1) break;
			outputStream.write(buffer,0,size);			//0부터 size 갯수만큼 내보내라
			count += size;
			
			double percent = count * 100.0 / total;
			System.out.println("(" +count+"/"+total+", "+f.format(percent)+")");
		}
		
		long finish = System.currentTimeMillis();
		System.out.println("시간 : " + finish);
		
		inputStream.close();
		outputStream.close();
		
	}

}
