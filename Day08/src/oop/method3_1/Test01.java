package oop.method3_1;

public class Test01 {
	public static void main(String[] args) {
		Phone p1 = new Phone();
		Phone p2 = new Phone();
		Phone p3 = new Phone();
		Phone p4 = new Phone();
		
		p1.setting("갤럭시22s", "SK", 1800000);
		p2.setting("갤럭시22s", "KT", 1750000, 24);
		p3.setting("아이폰14", "LG", 2000000, 30);
		p4.setting("아이폰14", "SK", 1990000);
		
		p1.output();
		p2.output();
		p3.output();
		p4.output();
	}
}