package oop.method3_1;

public class Phone {
	//member field
	String name;
	String telecom;
	int price;
	int month;
	
	//member method
	void setting(String name, String telecom, int price) {
		this.setting(name, telecom, price, 0);
	}
	void setting(String name, String telecom, int price, int month) {
		this.name = name;
		this.telecom = telecom;
		this.price = price;
		this.month = month;
	}
	
	void output() {
		System.out.println("<휴대폰 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("통신사 : " + this.telecom);
		if(this.month > 0) {//약정기간이 있다면
			System.out.println("가격 : " + this.price + "원");
			int monthPrice = this.price / this.month;
			System.out.println("(월 "+monthPrice+"원)");
		}
		else {
			int discountPrice = this.price * 95 / 100;
			System.out.print("가격 : " + discountPrice + "원");
			System.out.println("(원가 " + this.price+"원)");
			System.out.println("(약정기간 미설정, 일시불)");
		}
		System.out.println("약정기간 : " + this.month + "개월");
	}
}
