package oop.method4_1;

public class Test01 {
	public static void main(String[] args) {
		Item a = new Item();
		Item b = new Item();
		Item c = new Item();
		Item d = new Item();
		
		a.setting("참이슬후레쉬", "주류", 1200, true, true);
		b.setting("클라우드맥주", "주류", 3000, false, true);
		c.setting("바나나킥", "과자", 1500, false, true);
		d.setting("허니버터칩", "과자", 2000, true, false);
		
		a.output();
		b.output();
		c.output();
		d.output();
	}
}