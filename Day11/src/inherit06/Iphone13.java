package inherit06;

public class Iphone13 extends Apple{
	
	
	public Iphone13(String color, String number) {
		super(color, number);
		
	}

	public Iphone13(String color) {
		super(color);
		
	}
	
	

	@Override
	public void siri() {
		System.out.println("Iphone13의 음성인식 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("Iphone13의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("Iphone13의 문자 기능 실행");
	}

	public void itunes() {
		System.out.println("Iphone13의 아이튠즈 기능 실행");
	}

}
