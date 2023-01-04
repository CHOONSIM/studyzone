package random;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		
		//윷놀이 심층분석
		// - 윷놀이는 주사위처럼 균일하게 나오지 않는다.
		// - 확률을 알기 위해서는 '경우의 수' 라는 것을 따져야 한다.
		// - 윷놀이 총 16가지 가능성
		// - 도 (3/16) , 개(6/16) , 걸(4/16) , 윷(1/16) , 모(1/16) , 빽도(1/16)
		// - 6가지가 아니라 16가지로 계산하여 추첨
		
		Random r = new Random();
		
		int yut = r.nextInt(16);
		System.out.println("yut = " + yut);
		
		switch(yut) {  
		case 0,1,2:                  //콤마는 17에서만 가능
			System.out.println("도");
		    break;
		case 3,4,5,6,7,8:
			System.out.println("개");
		    break;
		case 9,10,11,12:
			System.out.println("걸");
		    break;
		case 13:
			System.out.println("윷");
		    break;
		case 14:
			System.out.println("모");
		    break;
		case 15:
			System.out.println("빽도");
		    break;
		}
	}

}
