package oop.abstract01;

public class Iphone14 extends Iphone{

	public Iphone14(String color) {
		super(color);
	}
	
	@Override
	public void siri() {
		System.out.println("아이폰14 음성인식");
	}

	@Override
	public void call() {
		System.out.println("아이폰14 전화");
		
	}


	@Override
	public void sms() {
		System.out.println("아이폰14 문자");
		
	}
	
	public void faceTime() {
		System.out.println("아이폰14 영상통화");
	}
	
	
	

}
