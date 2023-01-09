package oop.method4;

public class ShoppingMall {
	
	//member field
	int eventPer = 10;
	int deliveryFee = 2500;
	String name, sort;
	int price;
	boolean event, delivery;
	
	//member method
	void setting(String name, String sort, int price, boolean delivery, boolean event ) {
		this.name = name;
		this.sort = sort;
		this.price = price;
		this.delivery = delivery;
		this.event = event;
	}
	
	void output() {
		System.out.println("<상품 정보>");
		System.out.println("상품명 : " + this.name);
		System.out.println("상품분류 : " + this.sort);
		if(this.event == true) {
			System.out.println("판매가 : " + this.price * (100-eventPer)/100 + "원 "+"("+eventPer+"% 할인" + ")");
			System.out.println("행사여부 : 행사중");
		}
		else {
			System.out.println("판매가 : " + this.price + "원 ");
			System.out.println("행사여부 : 해당없음");
			
		}
		if(this.delivery == true) {
			System.out.println("새벽배송 : 가능" + "(" + "새벽 배송비 : " + deliveryFee + "원 추가"+")");
			System.out.println();
		}
		else {
			System.out.println("새벽배송 : 불가능");
			System.out.println();
		}
		
	}

}