package exception;

public class Test10 {
	public static void main(String[] args) {
		
		//목표 : 객체지향에서의 예외처리
		try {
		int value = calculator.div(10, 0);
//			int value = calculator.div(10, 2);
			System.out.println("value = " + value);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
