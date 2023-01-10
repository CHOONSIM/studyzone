package oop.inherit02;

public class Test01 {
	public static void main(String[] args) {
		
		//Iphone14 객체를 생성
		Iphone14 a = new Iphone14();
		a.setNumber("010-1234-5678");
		a.setColor("black");
		
		a.call();
		a.sms();
		a.color();
		a.airDrop();
		
		//GalaxyFold4 객체를 생성
		GalaxyFold4 b = new GalaxyFold4();
		b.setNumber("010-9876-5432");
		b.setColor("spaceGray");
		
		b.call();
		b.sms();
		b.color();
		b.SamsungPay();
	}

}
