package data3;
import java.lang.*;

public class Test01 {
	public static void main(String[] arg) {
		
	//문자 char
		//문자(글자, 글꼴, 인코딩 ...)
		//프로그래밍에서 글자를 표현하기 위한 방식
		//최초 - 미국인 개발, 미국인이 사용 가능한 글자 128개를 저장(ASCII)
		//변화 - 유럽 전파, 유럽인들까지 사용 가능하도록 256글자로 확장(확장ASCII , iso-8859-1
		//최종 - 전세계 전파, 전세계 글자를 통합하기 위해 unicode를 재정 (65536 자) -> 2Byte 
		//유니코드의 표현 방식 중 UTF-8이라는 방식이 존재함
		
		char a = '밥';
		System.out.println(a);
		int b = a;
		System.out.println(b);
		
		char c = 'H';
		c += 32;
		System.out.println(c);
		
		boolean lower ='a' <= c && c<= 'z';
		System.out.println(lower);
	}

}
