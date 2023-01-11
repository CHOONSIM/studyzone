package inherit06;

public class Samsung extends Phone{
	
	
	public Samsung(String color) {
		super(color);
	}

	public Samsung(String color, String number) {
		super(color, number);
	}
	
	
	//공통 메소드
	public void samsungPay() {
		System.out.println("삼성페이 기능 실행");
	}
	

}
