package inherit06;

public class Iphone14 extends Apple{
	
	
	public Iphone14(String color, String number) {
		super(color, number);	
	}

	public Iphone14(String color) {
		super(color);
	}
	
	

	@Override
	public void siri() {
		System.out.println("Iphone14의 음성인식 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("Iphone14의 통화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("Iphone14의 문자 기능 실행");
	}

	public void faceTime() {
		System.out.println("Iphone14의 영상통화 기능 실행");
	}

}
