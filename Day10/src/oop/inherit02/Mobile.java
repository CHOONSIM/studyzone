package oop.inherit02;

//상위 클래스(슈퍼 클래스 , 부모 클래스, ...)
//  - 객체 생성ㅇ ㅣ목적이 아니라 클래스들의 공통점을 보관하기 위한 클래스
public class Mobile {
	//공통 필드
	private String number;
	private String color;
	
	public void setNumber(String number) {
		this.number = number;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public String getColor() {
		return color;
	}
	
	//공통 메소드
	public void call() {
		System.out.println(getNumber());
	}
	public void sms() {
		System.out.println("문자");
	}
	public void color() {
		System.out.println(getColor());
	}

}
