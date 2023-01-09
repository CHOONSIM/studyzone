package oop.method2_1;

public class Test02 {
	public static void main(String[] args) {
		//객체 생성
		Menu a = new Menu();
		Menu b = new Menu();
		Menu c = new Menu();
		Menu d = new Menu();
		
		//정보 초기화
		a.setting("아메리카노", "음료", 2500, true);
		b.setting("모카라떼", "음료", 3500);
		c.setting("치즈케이크", "디저트", 5000, true);
		d.setting("마카롱", "디저트", 3000);
		
		//정보 출력
		a.output();
		b.output();
		c.output();
		d.output();
		
	}
}