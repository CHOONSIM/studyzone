package oop.modifier03;

public class Test01 {
	public static void main(String[] args) {
		
		ClassCharge c1 = new ClassCharge("자바 마스터과정", 90, 1000000, "온라인");
		ClassCharge c2 = new ClassCharge("파이썬 기초", 60, 600000, "온라인");
		ClassCharge c3 = new ClassCharge("웹 개발자 단기완성", 120, 1200000, "오프라인");
		
		c1.output();
		c2.output();
		c3.output();
		
	}

}
