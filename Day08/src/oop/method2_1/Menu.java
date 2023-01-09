package oop.method2_1;

//메뉴 정보를 보관할 클래스
public class Menu {
//	멤버 필드(변수) - 데이터 저장
	String name;
	String type;
	int price;
	boolean event;
	
//	멤버 메소드 - 기능 구현(코드 저장) 
	
//	같은 이름으로 형태만 다르게 메소드를 구현 - 메소드 오버로딩(method overloading)
//	void setting(String name, String type, int price) {
//		this.name = name;
//		this.type = type;
//		this.price = price;
//		this.event = false;
//	}
	void setting(String name, String type, int price) {
		this.setting(name, type, price, false);
	}
	void setting(String name, String type, int price, boolean event) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.event = event;
	}
	
	
	void output() {
		System.out.println("<메뉴 정보>");
		System.out.print("이름 : " + this.name);
		if(this.event) {
			System.out.print("(행사중)");
		}
		System.out.println();
		System.out.println("구분 : " + this.type);
		
		System.out.print("가격 : ");
		if(this.event) {
			int discountPrice = this.price * 80 / 100;
			System.out.print(discountPrice);
			System.out.print("(");
			System.out.print(this.price);
			System.out.print(")");
		}
		else {
			System.out.print(this.price);
		}
		System.out.println("원");
//		System.out.println("이벤트 : " + this.event);
	}
}
