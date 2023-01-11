package inherit06;

public class GalaxyFold4 extends Samsung{

	public GalaxyFold4(String color) {
		super(color);
		
	}
	public GalaxyFold4(String color, String number) {
		super(color, number);
		
	}


	public void iris() {
		System.out.println("GalaxyFold4의 홍재인식 기능 실행");
	}

	@Override
	public void samsungPay() {
		System.out.println("GalaxyFold4의 삼성페이 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("GalaxyFold4의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("GalaxyFold4의 문자 기능 실행");
	}
	

}
