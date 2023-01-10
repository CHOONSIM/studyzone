package oop.keyword02;

import java.util.Scanner;


//(주의) 클래스에서는 입력을 고려하지 않는다.
public class Member {
	
	private final String ID;
	private String password;
	private int point;
	
	public Member(String ID, String password) {
		this.ID = ID;
		this.setPassword(password);
		this.setPoint(100);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		if(point<0)return;
		this.point = point;
	}
	
	public void output() {
		System.out.println("<회원 정보>");
		System.out.println("아이디 : " + this.ID);
		System.out.println("비밀번호 : " + this.password);
		System.out.println("포인트 : " + this.point + "point");
	}

}
