package api.util.random;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

public class Test02_2 {

	public static void main(String[] args) {
		
//		OTP(One Time Password)를 만들려면?
//		- 랜던이긴 하지만 예측 가능해야 한다.
//		- 예측이 가능하여면 시드가 일정시간 동안 같아야한다.
//		- 어떻게 하면 60초마다 바뀌는 값을 만들 수 있을까?
//		- 시간을 통해 계산한다.
//		- 시간과 나눗셈을 통해 계산한다
//		- 서로 다른 회원은 서로 다른 OTP번호가 나와야 한다
//		- 다시 말해서 회원간의 시드가 달라야 한다.
//		- 시간과 개인정보를 합쳐서 시드를 구성하면 된다(이 로직을 걸리면 해킹당하는 것임)
		
		Random r = new Random();
		Format f = new DecimalFormat("000000");
		
		String a = "admin";		//String의 일련번호 hashCode()
		String b = "student";
		
		while(true) {
			long time = System.currentTimeMillis() / 1000L;  //1초마다
			long seedA = time + a.hashCode();		//String의 일련번호 + time 
			long seedB = time + b.hashCode();

			r.setSeed(seedA);  //seed 설정
			int otpA = r.nextInt(1000000) + 0;
			r.setSeed(seedA);  //seed 설정
			int otpB = r.nextInt(1000000) + 0;
			
			System.out.print("otpA = " + f.format(otpA));
			System.out.print(", otpB = " + f.format(otpB));
			System.out.println();
			
		}
	}

}
