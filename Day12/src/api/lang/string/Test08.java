package api.lang.string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test08 {

	public static void main(String[] args) {
//		사용자에게 아이디를 입력받아서 올바른 형식인지 검사한 뒤 결과를 출력하세요
//
//		아이디 형식
// 
//		글자수는 8~20자 입니다
//		알파벳 소문자로 반드시 시작해야 합니다
//		이후에는 알파벳 소문자 또는 숫자, 언더바(_)를 사용할 수 있습니다

		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		sc.close();
		 
		//String id = "yoyyo4"; 
		
		String regex = "^[a-z][a-z0-9_]{7,19}$";
	
		if(Pattern.matches(regex, id)) { 
			System.out.println("아이디 생성 완료"); 
		}
		else { 
			System.out.println("틀린 아이디 형식");
		}
	}

}
