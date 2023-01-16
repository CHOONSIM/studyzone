package api.util.random;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

public class Test02_1 {

	public static void main(String[] args) {
		
//		OTP(One Time Password)를 만들려면?
//		- 랜던이긴 하지만 예측 가능해야 한다.
//		- 예측이 가능하여면 시드가 일정시간 동안 같아야한다.
//		- 어떻게 하면 60초마다 바뀌는 값을 만들 수 있을까?
//		- 시간을 통해 계산한다.
//		- 시간과 나눗셈을 통해 계산한다
		
		Random r = new Random();
		Format f = new DecimalFormat("000000");
		
		while(true) {
			long time = System.currentTimeMillis() / 1000L;  //1초마다
//			System.out.println("time = " + time);
			
			r.setSeed(time);  //seed 설정
			
//			int otp = 000000~999999
			int otp = r.nextInt(1000000) + 0;
			
			System.out.println("otp = " + f.format(otp));
			
		}
		

	}

}
