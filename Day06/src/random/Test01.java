package random;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		
		//랜덤(Random)
		// - 무슨 값이 나올지 에측할 수 없는 데이터 상태
		// - 프로그램에서 랜덤 값을 생성하는 도구가 존재
		// - 확률 구현, 시뮬레이션,... 등을 할 수 있음
		// - 완전한 랜덤은 구현이 어려움
		// - Random이라는 도구를 생성해서 랜덤값을 구현(유사랜덤)
		
		Random r = new Random();
		
		int a = r.nextInt();
		System.out.println(a);
		
		
		//nextInt(개수)를 사용하면 0부터 해당 개수만큼의 정수 중에서 랜덤으로 반환
		int b = r.nextInt(6);
		System.out.println("b = " + b);
		
		//주사위는 1부터6까지
		//r.nextInt(B) + A -> A부터 B개
		int dice  = r.nextInt(6) + 1;
		System.out.println("dice + " + dice);
		
		//r.close();  -  이런 명령은 없음 (close 입출력에만 존재)
	}

}
