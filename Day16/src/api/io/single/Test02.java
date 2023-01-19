package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) throws IOException {
		
//		목표 : 싱글바이트 단위 데이터 입력(열기)
//		준비물 : 파일 객체(없으면 에러), 스트림 객체(입력용)
		File target = new File("temp", "single.kh");
		if(!target.isFile()) {
			System.err.println("존재하지 않는 파일입니다.");
			System.exit(-1);
		}
		FileInputStream stream = new FileInputStream(target);
//		구조 : [프로그램] <- stream <- target <- [single.kh]
		
//		[1] for를 이용하여 파일 크기만큼 반복
//		- 사용하지 않음(나중에는 여러 글자를 불러오므로 횟수 계산이 어려움)
//		for(int i=0; i<target.length(); i++) {
//			int n =stream.read();
//			System.out.println("n = " + n);		
//		}
		
//		[2] while을 이용하여 반복 읽기				-1(아스키코드에 없음 끝이라는 표현), EOF(End Of File)
//		EOF(End Of File) 값인 -1이 나올 때까지 입력
		while(true) {
			int n =stream.read();
			if(n == -1) break;
			System.out.println("n = " + n);
		}
		
//		다 쓴 통로는 정리
		stream.close();
	}

}
