package oop.method3;

public class TelecomTest {
	public static void main(String[] args) {
		
		Telecom t1 = new Telecom();
		Telecom t2 = new Telecom();
		Telecom t3 = new Telecom();
		Telecom t4 = new Telecom();
		
		
		t1.setting("갤럭시22s", "SK", 1800000, 0, false);
		t2.setting("갤럭시22s", "KT", 1750000, 24, true);
		t3.setting("아이폰14", "LG", 2000000, 30, true);
		t4.setting("아이폰14", "SK", 1990000, 0, false);
		
		t1.output();
		t2.output();
		t3.output();
		t4.output();
	}

}