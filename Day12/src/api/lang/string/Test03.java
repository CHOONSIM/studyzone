package api.lang.string;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		
		//String ni = "nickname1234";
		
     	Scanner sc = new Scanner(System.in);
	    System.out.println("닉네임을 정하세요.");
		String ni = sc.next();
		
		
		if(ni.contains("운영자")){
			System.out.println("운영자를 포함한 닉네임은 만들 수 없습니다.");
		}
		else if (!(ni.length() >= 2 && ni.length() <= 10)){
			System.out.println("닉네임을 2~10글자로 작성해주세요.");
		}
		else {
			System.out.println("올바른 닉네임입니다.");
		}
	
	}

}
