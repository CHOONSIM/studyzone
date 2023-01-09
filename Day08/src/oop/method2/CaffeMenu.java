package oop.method2;

public class CaffeMenu {
	
	String menu, category ,sale;
	int price; boolean Dc; int discount = 20;
	
	void setting(String menu, String category, int price, 
			boolean Dc) {
		this.menu = menu;
		this.category = category;
		this.price = price;
		this.Dc = Dc;
	}
	void output() {
		System.out.println("<메뉴 정보>");
		if(this.Dc == true) {
			System.out.println("메뉴 : " + this.menu + " 행사중");
			System.out.println("분류 : " + this.category);
			System.out.println("가격 : " + this.price *(100-discount)/100 + "원");
			System.out.println("행사여부 : 행사중");
		}
		else {
			System.out.println("메뉴 : " + this.menu);
			System.out.println("분류 : " + this.category);
			System.out.println("가격 : " + this.price +"원");
			System.out.println("행사여부 : - ");
		}
		System.out.println();
	}
}