package oop.method2;

public class CaffeMenuTest {
	public static void main(String[] args) {
		
		//객체 생성
		CaffeMenu m1 = new CaffeMenu();
		CaffeMenu m2 = new CaffeMenu();
		CaffeMenu m3 = new CaffeMenu();
		CaffeMenu m4 = new CaffeMenu();
		
		m1.setting("아메리카노", "음료", 2500, true);
		m2.setting("모카라떼", "음료", 3500, false);
		m3.setting("치즈케이크", "디저트", 5000, true);
		m4.setting("마카롱", "디저트", 3000, false);
		
		
		m1.output();
		m2.output();
		m3.output();
		m4.output();
			
		}

	}