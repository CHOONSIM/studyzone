package oop.keyword04;

public class GalaxyFold4 {
	
	//데이터를 정적(static)과 동적(dynamic)으로 구분하여 생각하자!
	// - 정적인 데이터는 만들지 않아도 알 수 있으며, 모두가 동일하게 관리되어야 한다.
	// - Static이라는 키워를 이용하여 표시를 해준다.
	// - getter/setter 메소드도 static으로 구현해야 한다
		private static String company = "Samsung";
	
	// - 동적인 데이터는 객체를 만들면서 설정하며, 개체마다 각자 다르게 관리한다.
	// - 일반 필드로 생성한다.
	private String numer;
	private String color;
	
	//생성자에서는 static 항목을 초기화하지 않는다.
	public GalaxyFold4(String number, String color) {
		//this.setCompany("삼성");   비추천
		this.setNumer(number);
		this.setColor(color);
	}
	
	public void output() {
		System.out.println("번호 : " + this.getNumer());
		System.out.println("색상 : " + this.getColor());
		//System.out.println("제조사 : " + this.getCompany());  //잘못된 방법
		System.out.println("제조사 : " + getCompany());
		//  or  System.out.println("제조사 : " + GalaxyFold4.getCompany());
	}
	
	public static void setCompany(String company) {
		GalaxyFold4.company = company;               //this 사용불가
	}
	public void setNumer(String numer) {
		this.numer = numer;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public static String getCompany() {
		return company;
	}
	public String getNumer() {
		return numer;
	}
	public String getColor() {
		return color;
	}
	
	
	

}
