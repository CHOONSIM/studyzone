package loop;

public class Test06 {

	public static void main(String[] args) {
		//반복문의 활용 - 카운트, 누적합계
		
		// Q) 1부터 100사이의 짝수 개수는?
		//미리 카운트 측정을 위한 변수를 0으로 설정
		int cnt = 0;  //int count = 0;
		
		for(int i=1; i<=100; i++) {
			if(i % 2 ==0) {
				System.out.println(i);
				cnt++;
			}
		}
		
		System.out.println("cnt = " + cnt);
		
		
		
		// Q) 1부터 100까지의 합계는?
		int total = 0;
		for(int i=1; i<=100; i ++) {
			total += i;
		}
		System.out.println("total = "+ total);

	}

}
