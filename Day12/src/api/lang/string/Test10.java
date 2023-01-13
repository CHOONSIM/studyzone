package api.lang.string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("생년월일을 입력하세요");
		String birth = sc.next();

		sc.close();
		
		//String regex = "^(19\\d{2}|20\\d{2})-(0\\d|1[0-2])-(0\\d|[1-2]\\d|3[0-1])$";
		//String regex = "^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";
		String regex1 = "^(19\\d{2}|20\\d{2})(0[13578]|1[02])(0[1-9]|[1-2][0-9]|3[0-1])$";  //31일
		String regex2 = "^(19[0-9][0-9]|20\\d{2})(0[2469]|1[1])(0[1-9]|[1-2][0-9]|3[0])$";  //30일
		if(Pattern.matches(regex1, birth)){
			System.out.println("올바른 생년월일 입니다.");
		}
		else if(Pattern.matches(regex2, birth)){
			System.out.println("올바른 생년월일 입니다.");
		}
		else 
			System.out.println("틀린 생년월일 입니다.");
	}

}
