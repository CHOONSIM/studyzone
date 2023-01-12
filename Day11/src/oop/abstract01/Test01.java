package oop.abstract01;

public class Test01 {
	public static void main(String[] args) {
		//Mobile m = new Mobile();   X
		//Iphone i = new Iphone();   X
		//Galaxy g = new Galaxy();   X
		
		//객체로 만들 수 있는건 4개뿐
		
	Iphone13 a = new Iphone13("블랙");
	a.call();
	a.sms();
	a.siri();
	a.itunes();
	
	Iphone14 b = new Iphone14("실버");
	b.call();
	b.sms();
	b.siri();
	b.faceTime();
	
	Galaxy22s c = new Galaxy22s("블루");
	c.call();
	c.sms();
	c.smasungPay();
	c.bixby();
	
	GalaxyFold4 d = new GalaxyFold4("레드");
	d.call();
	d.sms();
	d.smasungPay();
	d.iris();
	
	}
	
	

}
