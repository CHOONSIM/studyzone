package api.io.file;

import java.io.File;

public class Test02 {
	public static void main(String[] args) {
		
//		디렉토리 분석
//		- 자바는 파일과 디렉토리의 생성방법이 같다(사용법은 다름)
		
		File dir = new File("temp");
		
		if(!dir.isDirectory()) {
			System.out.println("디렉토리가 아닙니다.");
			System.exit(-1); 					//0은 긍정 -1은 부정
		}
		
//		디렉토리는 크기가 없다(내용물의 크기만 있을 뿐)
		System.out.println(dir.length());
		
//		디렉토리에서 의미가 있는 것은?
//		- 안에 무엇이 있느냐가 중요한 포인트, 이와 관련된 명령이 존재
//		- .listFiles()를 사용하여 내부에 들어있는 파일 목록을 반환
		
		File[] files = dir.listFiles();
		System.out.println("파일 개수 : " + files.length);		//파일 개수
		
//		for(int i=0; i<files.length; i++) {  // -> 조회 + 변경
		for(File file : files) {			 // -> 조회
			System.out.println(file.getPath());
//			System.out.println(file.getAbsolutePath());
		}
	}

}
