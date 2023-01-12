package oop.abstract01;

public class GalaxyFold4 extends Galaxy{

	public GalaxyFold4(String color) {
		super(color);
	}

	@Override
	public void smasungPay() {
		System.out.println("갤럭시폴드4 삼성페이 기능");
		
	}

	@Override
	public void call() {
		System.out.println("갤럭시폴드4 전화 기능");
		
	}

	@Override
	public void sms() {
		System.out.println("갤럭시폴드4 문자 기능");
		
	}
	
	public void iris() {
		System.out.println("갤럭시폴드4 홍채인식 기능");
	}
	
	

}
