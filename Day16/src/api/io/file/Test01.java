package api.io.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {

	public static void main(String[] args) {
		
//		파일 제어
//		- java에서는 파일 및 디렉토리를 모두 File 클래스로 제어한다.
		
//		파일을 제어할 대상 파일의 객체를 생성(없어도 생성 가능, 오타 조심)
		File a = new File ("temp/hello.txt");
		File b = new File ("temp", "hello.txt");
		
		System.out.println("성공!");
		
//		파일 분석
		System.out.println(a.exists());			//존재하는 파일인가?
		System.out.println(b.exists());
		
		System.out.println(a.isFile());			//파일인가?
		System.out.println(a.isDirectory());	//디렉토리인가?
		
		System.out.println(a.length());			//파일 크기(=들어있는 글자의 바이트 수)
		
		System.out.println(a.getName());		//파일명
		System.out.println(a.getPath());		//파일위치(상대경로)
		System.out.println(a.getAbsolutePath());//파일위치(절대경로)
		
		/*상대경로와 절대경로
		- 상대경로는 특정 지점을 기준으로 계산한 경로(ex: 우리 옆집 , 내 앞 등)
		  편함, 오해의 소지가 있음
			./는 현재 경로를 의미하며 생략 가능하다.
			../는 현재 경로의 상위 경로를 의미한다.
		- 절대경로는 모든 상황에서 동일한 경로(ex : 서울시 영등포구 선유로길 59)
		 	길다, 정확함
		 */
		
		System.out.println(a.canRead());		//읽기 가능?
		System.out.println(a.canWrite());		//쓰기 가능?
		System.out.println(a.isHidden());		//숨겨진 파일?
		
		System.out.println(a.lastModified());	//마지막 수정 시각(밀리세컨, 최신파일 비교)
		Date d = new Date(a.lastModified());
		Format f = new SimpleDateFormat("y년 M월 d일 H시 m분 s초");
		System.out.println(f.format(d));
		
	}

}
