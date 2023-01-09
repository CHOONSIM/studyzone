package oop.method3;

public class Telecom {
	
	String name, company;
	boolean month;
	int price;
	int agreement;
	int Dc = 5;
	
	void setting (String name, String company, int price, int agreement, boolean month)
	{
		this.name = name;
		this.company = company;
		this.price = price;
		this.agreement = agreement;
		this.month = month;
		
	}
	
	void output() {
		System.out.println("<판매정보>");
		if(this.month == true) {
			System.out.println("이름 : " + this.name);
			System.out.println("통신사 : " + this.company);
			System.out.println("가격 : " + this.price +"원");
			System.out.println("약정개월 : " + this.agreement + "개월");
			System.out.println("할부금액 : " + this.price/this.agreement+ "원");
			System.out.println();
		}
		
		else {
			System.out.println("이름 : " + this.name);
			System.out.println("통신사 : " + this.company);
			System.out.println("가격 : " + this.price * (100-Dc)/100 + "원" + " (약정없음)");
			System.out.println("약정개월 : 설정하지 않음");
			System.out.println();
		}
	}
}	