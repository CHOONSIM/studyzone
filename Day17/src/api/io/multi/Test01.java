package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) throws IOException {
		
//		멀티 바이트 출력
//		준비물 : 파일 객체(없으면 생김), 출력 스트림, +분해 스트림 , +버퍼 스트림
		
		File target = new File("temp","multi.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream); //(stream,크기생략되어있음8192)
		DataOutputStream mixer = new DataOutputStream(buffer);
		
//		[프로그램] -> mixer -> buffer -> stream -> target -> [multi.kh]
		mixer.writeBoolean(false);		//boolean 형식으로 분해해서 출력
		mixer.writeByte(100); 			//byte 형식으로 분해해서 출력
		mixer.writeInt(100); 			//int 형식으로 분해해서 출력
		mixer.writeChar(100); 			//char 형식으로 분해해서 출력
		mixer.writeLong(100L); 			//long 형식으로 분해해서 출력
		mixer.writeFloat(100f); 		//float 형식으로 분해해서 출력
		mixer.writeDouble(100d); 		//double 형식으로 분해해서 출력
		
//		총 합계 28byte, 버퍼 크기는 기본 8192byte
//		버퍼는 가득 차야 전송이 된다. 그전까지는 안나감
//		만약 프로그램 종료 등 여러 이유로 버퍼가 가득차지 않아도 전송하려면
//		강제 전송 명령을 사용해야함.
//		mixer.flush(); 					//강제 전송 명령		전송only
		mixer.close(); 					//flush 수행 후 종료	전송 + close

	}

}
