package api.io.string;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) throws IOException {
		
//		문자열과 바이트간의 변환
//		- .getBytes()로 문자열을 바이트 배열로 변환가능
		String str = "hello 안녕하세요";
		
		byte[] b1 = str.getBytes(/*"UTF-8"*/);
		System.out.println("b1 = " + Arrays.toString(b1));
		
		byte[] b2 = str.getBytes("MS949");
		System.out.println("b2 = " + Arrays.toString(b2));
		
		
//		- 바이트 배열을 문자열로 만들려면 String생성자를 사용
		String s1 = new String(b1);
//		String s1 = new String(b1, "UTF-8");
		System.out.println("s1 = " + s1);
		
		String s2 = new String(b2, "MS949");
		System.out.println("s2 = " + s2);
		
	}

}
