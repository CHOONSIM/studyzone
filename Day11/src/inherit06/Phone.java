package inherit06;

public class Phone {
	
	//공통필드 - 접근제한(private/protected)
	private String number;     //현재는 둘다 가능
	protected String color;
	
	//생성자 - 반드시 초기화가 필요한 필드
	public Phone(String color) {
		this.color = color;
	}
	public Phone(String color, String number) {
		this.color = color;
		this.number = number;
	}
	
	
	//공통메소드 - 재정의(X/final)
	public void call() {
		System.out.println("통화 기능 실행");
	}
	
	public void sms() {
		System.out.println("문자 기능 실행");
	}
	

}
