package inherit06;

public class Test01 {
	public static void main(String[] args) {
		
		Galaxy22s g22 = new Galaxy22s("010-0000-0000", "블랙");
		g22.call();
		g22.sms();
		g22.samsungPay();
		g22.bixby();
		System.out.println();

		GalaxyFold4 b = new GalaxyFold4("010-2020-3030", "퍼플");
		b.call();
		b.sms();
		b.samsungPay();
		b.iris();
		System.out.println();
	
		Iphone13 c = new Iphone13("010-3030-4040", "실버");
		c.call();
		c.sms();
		c.siri();
		c.itunes();
		System.out.println();
	
		Iphone14 d = new Iphone14("010-4040-5050", "블랙");
		d.call();
		d.sms();
		d.siri();
		d.faceTime();
	
	}

}
