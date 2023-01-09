package oop.method4_1;

public class Item {
	//field
	String name;//상품명
	String type;//상품분류
	int price;//판매가
	boolean early;//새벽배송 여부
	boolean event;//행사 여부
	
	//method
	void setting(String name, String type, int price) {
		this.setting(name, type, price, false, false);
	}
//	void setting(String name, String type, int price, boolean early) {
//		
//	}
//	void setting(String name, String type, int price, boolean event) {
//		
//	}
	void setting(String name, String type, int price, boolean early, boolean event) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.early = early;
		this.event = event;
	}
	
	void output() {
		System.out.println("<상품 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("구분 : " + this.type);
		
		if(this.event) {
			int discountPrice = this.price * 90 / 100;
			System.out.print("가격 : ");
			System.out.print(discountPrice);
			System.out.print("("+this.price+")");
			System.out.println("원");
		}
		else {
			System.out.println("가격 : " + this.price + "원");
		}
		
		if(this.early) {
			System.out.println("(새벽배송비 2500원 추가)");
		}
//		System.out.println("새벽배송 : " + this.early);
//		System.out.println("행사여부 : " + this.event);
	}
}
