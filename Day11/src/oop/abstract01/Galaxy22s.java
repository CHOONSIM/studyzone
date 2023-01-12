package oop.abstract01;

public class Galaxy22s extends Galaxy{

	public Galaxy22s(String color) {
		super(color);
		}

	@Override
	public void smasungPay() {
		System.out.println("갤럭시22s 삼성페이 기능");
		
	}

	@Override
	public void call() {
		System.out.println("갤럭시22s 전화 기능");
		
	}

	@Override
	public void sms() {
		System.out.println("갤럭시22s 문자 기능");
		
	}
	
	public void bixby() {
		System.out.println("갤럭시22s 음성인식 기능");
	}

}
