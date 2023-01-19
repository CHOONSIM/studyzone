package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test03 {

	public static void main(String[] args) throws IOException {
	
//		File target = new File("temp","lotto.kh");

		List<Integer> lottery = new ArrayList<>();		//셔플 사용한 중복없는 로또번호
		
		for(int i=0; i<45; i++) {
			lottery.add(i);
		}
		Collections.shuffle(lottery);
		
		List<Integer> numbers = lottery.subList(0,6);
		
		
//		파일 출력
		File dir = new File("temp");
		dir.mkdirs(); 				//디렉토리 생성
		File target = new File(dir, "lotto.kh");
						
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream bufferOut = new BufferedOutputStream(out);
		DataOutputStream combine = new DataOutputStream(bufferOut);
		
		for(int number : numbers) {
			combine.writeInt(number);
		}

		combine.close();
		

	}

}
