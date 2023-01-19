package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test01 {

	public static void main(String[] args) throws IOException {
		
//		객체 출력
//		- 자바에서 가장 복잡하며 형태를 예측하기 어려운 데이터 유형
//		- 멀티바이트처럼 크기가 정해져 있지도 않음
//		- 분해가 가능하도록 펼치는 작업이 추가로 필요(직렬화)
//		- 직렬화 → 분해 → 임시저장 → 전송
//		- (직렬화 + 분해) 묶어서 ObjectOutputStream
		
		File target = new File("temp", "object.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream mixer = new ObjectOutputStream(buffer);
		
//		[프로그램] → mixer → buffer → stream → target → [object.kh]
		Date d = new Date();		//시간객체
		mixer.writeObject(d);
		
		mixer.close();
		System.out.println("저장완료");
		
	}

}
