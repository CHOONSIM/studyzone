package jdbc.test;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test01 {

	public static void main(String[] args) {
		
		MemberDto dto = new MemberDto();
		MemberDao dao = new MemberDao();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("회원가입을 위한 정보를 입력");
		
		System.out.print("아이디 입력 : ");
		while(true) {
			String a = sc.nextLine();
			if(a.matches("^[a-z0-9_-]{5,20}$")) {
				dto.setMemberId(a);
				System.out.println("아이디 입력완료");
				break;
			}
			else {
				System.out.println("영문 소문자,숫자,-,_를 사용, 5~20자이내로 입력");
				System.out.print("아이디 입력 : ");
			}
		}
		
		System.out.print("비밀번호 입력 : ");
		while(true) {
			String a = sc.nextLine();
			if(a.matches("^[A-Za-z0-9~!@#$%^&*]{8,16}$")) {
				dto.setMemberPw(a);
				System.out.println("비밀번호 입력완료");
				break;
			}
			else {
				System.out.println("영문 대소문자, 숫자, 특수문자 포함하여 8~16자이내로 입력");
				System.out.print("비밀번호 입력 : ");
			}
		}
		
		System.out.print("닉네임 입력 : ");
		while(true) {
			String a = sc.nextLine();
			if(a.matches("^[가-힣0-9]{2,10}$")) {
				dto.setMemberNick(a);
				System.out.println("닉네임 입력완료");
				break;
			}
			else {
				System.out.println("한글과 숫자를 사용하여 2~10자이내로 입력");
				System.out.print("닉네임 입력 : ");
			}
		}
		
		System.out.print("핸드폰 번호 : ");
		while(true) {
			String a = sc.nextLine();
			if(a.matches("^010([0-9]{4})([0-9]{4})$")) {
				dto.setMemberTel(a);
				break;
			}
			else {
				System.out.println("-를 제외하고 숫자만 입력");
				System.out.print("핸드폰 번호 : ");
			}
		}
		
		System.out.print("이메일 입력 : ");
		dto.setMemberEmail(sc.nextLine());
		
		System.out.print("생년월일 입력 : ");
		while(true) {
			String a = sc.nextLine();
			if(a.matches("^(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$")) {
				dto.setMemberBirth(a);
				break;
			}
			else {
				System.out.println("YYYY-MM-DD 형식으로 입력");
				System.out.print("생년월일 입력 : ");
			}
		}
		
		System.out.print("우편번호 : ");
		while(true) {
			String a = sc.nextLine();
			if(a.matches("^[0-9]{5,6}$")) {
				dto.setMemberPost(a);
				break;
			}
			else {
				System.out.println("숫자 5~6자이내로 입력");
				System.out.print("우편번호 : ");
			}
		}
		
		System.out.print("기본주소 : ");
		while(true) {
			String a = sc.nextLine();
			if(a.matches("^[가-힣0-9\s]{0,100}$")) {
				dto.setMemberPost(a);
				break;
			}
			else {
				System.out.println("한글 100자이내로 입력");
				System.out.print("기본주소 : ");
			}
		}
		
		System.out.print("상세주소 : ");
		while(true) {
			String a = sc.nextLine();
			if(a.matches("^[가-힣0-9\s]{0,100}$")) {
				dto.setMemberPost(a);
				break;
			}
			else {
				System.out.println("한글 100자이내로 입력");
				System.out.print("상세주소 : ");
			}
		}
		
		sc.close();
		

		dao.insert(dto);
		
		System.out.println("회원가입이 완료되었습니다.");
				
	}
}

	


