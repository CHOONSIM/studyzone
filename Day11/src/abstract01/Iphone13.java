package abstract01;

public class Iphone13 extends Iphone{

	public Iphone13(String color) {
		super(color);
	}

	@Override
	public void siri() {
		System.out.println("아이폰13 음성인식");
	}

	@Override
	public void call() {	
		System.out.println("아이폰13 전화");
	}

	@Override
	public void sms() {		
		System.out.println("아이폰13 문자");
	}
	
	public void itunes() {
		System.out.println("아이폰13 아이튠즈");
	}

}
