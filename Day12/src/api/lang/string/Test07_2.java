package api.lang.string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test07_2 {
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		sc.close();
		
		String regex = "^[가-힣]{2,3}$";
		
		if (Pattern.matches(regex, name)){
			System.out.println("올바른 이름");
		}
		else {
			System.out.println("잘못된 이름");
		}
		 
	}

}
