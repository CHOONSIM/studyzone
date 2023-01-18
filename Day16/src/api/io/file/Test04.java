package api.io.file;

import java.io.File;

public class Test04 {

	public static void main(String[] args) {
		
//		또 다른 파일 생성 방법
		
//		File dir = new File("temp");		//디렉토리 생성
//		File target = new File(dir, "hello.txt");
		
		File target = new File("temp");					//특정 위치에서 안으로 들어가기(폴더 안의 폴더)
		target = target.getAbsoluteFile();				//절대경로로 변환
		target = new File(target,"hello.txt");
		target = target.getParentFile();				//상위 폴더로 이동
		
//		while 사용하여 최상위로 이동 가능(null이 될때까지)
		
		System.out.println(target);
	}

}
