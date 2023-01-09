package oop.method4;

public class ShoppingMallTest {
	public static void main(String[] args) {
		
		ShoppingMall m1 = new ShoppingMall();
		ShoppingMall m2 = new ShoppingMall();
		ShoppingMall m3 = new ShoppingMall();
		ShoppingMall m4 = new ShoppingMall();
		
		m1.setting("참이슬후레쉬","주류", 1200, true, true);
		m2.setting("클라우드맥주", "주류", 3000, false, true);
		m3.setting("바나나킥", "과자", 1500, false, true);
		m4.setting("허니버터칩", "과자", 2000, true, false);
		
		m1.output();
		m2.output();
		m3.output();
		m4.output();
		
	}

}