package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;

public class Test03 {

	public static void main(String[] args) throws IOException {
		
//		복사 붙여넣기
//		한개씩 옮기므로 용량이 커질수록 느려짐 
		
		
//		입력
		File target = new File("temp", "single.kh");
		File newtarget = new File("temp", "copy.kh");
		
		FileInputStream inputStream = new FileInputStream(target);
		FileOutputStream outputStream = new FileOutputStream(newtarget);
		
//		count를 통해 진행상황 파악이 가능하도록 처리
		long total = target.length();
		long count = 0L;
		Format f = new DecimalFormat("#,##0.00");
		
		while(true) {
			int n =inputStream.read();
			if(n == -1) break;
			
			outputStream.write(n);		
			count++;					//내보낼때 계산
			double percent = count * 100.0 / total;
			System.out.println("(" +count+"/"+total+", "+f.format(percent)+")");
		}
		
		inputStream.close();
		outputStream.close();

	}

}
