package inherit06;

public class Galaxy22s extends Samsung{
	
	
	public Galaxy22s(String color, String number) {
		super(color, number);
		
	}

	public Galaxy22s(String color) {
		super(color);
		
	}

	//필요한 기능 재정의
	@Override
	public void call() {
		System.out.println("Galaxy22s의 전화 기능 실행");
	}
	
	@Override
	public void sms() {
		System.out.println("Galaxy22s의 문자 기능 실행");
	}
	
	@Override
	public void samsungPay() {
		System.out.println("Galaxy22s의 삼성페이 기능 실행");
	}
	
	//고유기능 추가
	public void bixby() {
		System.out.println("Galaxy22s의 음성인식 기능 실행");
	}

}
