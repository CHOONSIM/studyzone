package api.io.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) throws IOException {
		
//		목표 : 싱글바이트 단위 데이터 출력(저장)
//		준비물 : 파일 객체(없으면 생김) , 스트림 객체(출력용 통로)
		
//		도구 준비
		File target = new File("temp", "single.kh");
		FileOutputStream stream = new FileOutputStream(target);
		
//		구조 : [프로그램] -> [stream] -> [target] -> [single.kh]
		stream.write(104);
		stream.write(101);
		stream.write(108);
		stream.write(108);
		stream.write(111);
		stream.write(32); 		//spacebar
		stream.write('j');
		stream.write('a');
		stream.write('v');
		stream.write('a');
		stream.write(10);		// \n
		
		stream.write(30000);	// '0' (48)로 변환되어 출력  
		
		byte[] b = new byte[] {'H','E', 'L', 'L', 'O'};
		stream.write(b); 		//b에 들어있는 모든 값을 순서대로 출력
		stream.write(b,0,4);	//b 배열을 0번부터 4개 출력
		
//		입출력 통로는 반드시 close()가 필요
		stream.close();

	}

}
