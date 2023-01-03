package loop;

public class Test07 {

	public static void main(String[] args) {
		//새해 맞이 다이어트
		//푸쉬업 30일 동안
		//첫날 5개 둘째날부터는 전날보다 2개씩 개수를 늘려서
		// 1. 일자별로 하게되는 푸시업 개수
		// 2. 30일동안 하게되는 푸시업 개수 합
		// 3. 첫날 개수와 증가 폭, 기간을 입력받아서 출력
		
		int cnt = 0;
		
		int firstDay = 5;
		int addDay = 2;
		int day = 30;
		
		for(int i = 1; i<= day; i++) {
			System.out.println(i);
		}	

	}

}
