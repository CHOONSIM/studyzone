
package random;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		
		//다음에서 요구하는 랜덤값을 구하여 출력
		//1. 로또 번호 1개(1~45)
		//2. 두 자리 정수 중 1개
		//3. OTP 번호 1개(6자리)
		//4. 동전을 던진 결과 출력(앞 또는 뒤)
		//5. 윷놀이 한 턴 결과 출력(6개)
		
		Random r = new Random();
		
		//1. 로또 번호 1개(1~45)
		int lottery = r.nextInt(45)+1;
		System.out.println("로또 번호 = " + lottery);
		
		
		//2. 두 자리 정수 중 1개
		//10부터 99까지
		//10부터 (99-10+1)개
		//10부터90개
		int num = r.nextInt(90) +10;
		System.out.println("두 자리 정수 = " + num);
		
		
		//3. OTP 번호 1개(6자리)
		//100000 부터 999999
		//100000 부터 (999999 - 100000 + 1)개
		//100000 부터 900000개
		int otp = r.nextInt(900000)+100000;
		System.out.println("otp 번호 = " + otp);
		
		
		//4. 동전을 던진 결과 출력(앞 또는 뒤)
		//범위를 알 수 없음
		//임의로 지정을 해야 함
		//1,2 로 지정하면 1부터 2개
		//0,1 로 지정하면 0부터 2개
		//int coin = r.nextInt(2)+1;
		//int coin = r.nextInt(2)+0;  +0; 생략가능
		int coin = r.nextInt(2);
		if(coin == 0) {
			System.out.println("앞");
		}
		else {
			System.out.println("뒤");
		}
		
		
		//5. 윷놀이 한 턴 결과 출력(6개)
		//4번식을 푼다면 도0 개1 걸2 윷3 모4 빽도5
		//0부터 6개
		//확률 다 동일
		int yoot = r.nextInt(6);
		if(yoot == 0) {
			System.out.println("도");
		if(yoot == 1) {
			System.out.println("개");
		}
			
		}
	}

}

