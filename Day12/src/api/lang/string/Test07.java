package api.lang.string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		sc.close();
		 
		
		if (!(Pattern.matches("^[가-힣]*$", name))){
			System.out.println("이름에 사용 가능한 문자를 사용해주세요");
		}
		else if(!(name.length() >= 2 && name.length() <=7)) {
			System.out.println("글자수가 잘못입력 되었습니다");
		}
		else {
			System.out.println("이름이 설정되었습니다.");
		}
		
	}

}
