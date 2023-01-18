package api.util.collection4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Map<String,String> data = new HashMap<>();
		
		data.put("khacademy", "master1234");
		data.put("khstudent", "study1234");
		data.put("khmanager", "admin1234");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PW : ");
		String pw = sc.nextLine();
		
		if(data.containsKey(id)&& data.get(id).equals(pw)) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
		
		
		
		
//		while(true) {
//			Scanner sc = new Scanner(System.in);
//			System.out.print("ID : ");
//			String id = sc.nextLine();
//			System.out.print("PW : ");
//			String pw = sc.nextLine();
//			
//			if(!data.containsKey(id)) {
//				System.out.println("아이디가 일치하지 않습니다.");
//			}
//			else {
//				if(data.get(id).equals(pw)) {
//					System.out.println("로그인 성공");
//					return;
//				}
//				else {
//					System.out.println("비밀번호가 일치하지 않습니다.");
//				}
//			}
//		}
	}

}
