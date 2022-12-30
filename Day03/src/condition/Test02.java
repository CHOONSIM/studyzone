package condition;
import java.lang.*;

public class Test02 {
	public static void main(String[] args) {
		//어떤 숫자가 있을 때 이 숫자가 홀수인지 짝수인지 판정해서 메세지 출력
		
		//입력
		int num = 23;
		
		//처리
		boolean a = num % 2 == 0;
		//System.out.println(a);
		
		if(a) {
			System.out.println("짝수입니다.");
		}
		if(!a) {
			System.out.println("홀수입니다.");
		}
	}

}
