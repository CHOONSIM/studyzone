package inherit06;

public class Apple extends Phone{
	
	public Apple(String color, String number) {
		super(color, number);
		
	}
	public Apple(String color) {
		super(color);
		
	}
	
	public void siri() {
		System.out.println("음성인식 기능 실행");
	}
	
	


}
