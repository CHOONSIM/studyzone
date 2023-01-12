package api.lang.string;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		String ID = "khacademy";
		String PW = "student1234";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력");
		String a = sc.next();
		
		System.out.println("비밀번호 입력");
		String b = sc.next();
		
		sc.close();
		
		if(ID.equalsIgnoreCase(a) && (PW.equals(b))) {
			System.out.println("로그인 성공");
		}
//		if(id.equalsIgnoreCase("khacademy") && pw.equals("student1234")) {
//			System.out.println("로그인 성공!");
//		}
		else {
			System.out.println("로그인 실패");
		}
	}
}
