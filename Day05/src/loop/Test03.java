package loop;

public class Test03 {

	public static void main(String[] args) {
	
		
		// 1. 1부터 100까지 출력
		for(int i = 1; i<=100; i++) {
			System.out.println(i);
		}
		System.out.println();
		
		// 2. 1부터 100까지 홀수를 출력
		for(int i = 1; i<100; i+=2) {
			System.out.println(i);
		}
		System.out.println();
		
		// 2-1 1부터 100까지 홀수를 출력
		for(int i = 1; i<=100; i++) {  //1부터 100까지
			if(i % 2 != 0) {  //홀수라면
				System.out.println(i);
			}
		}
		
		// 3. 1부터 100까지 5의 배수 룰력
		for(int i = 0; i<=100; i+=5) {
			System.out.println(i);
		}
		System.out.println();
		
		//3-1 1부터 100까지 5의 배수 출력
		for(int i =1; i<=100; i++ ) {
			if(i % 5 == 0) {
				System.out.println(i);
			}
		}
		System.out.println();
		
		// 4. 10부터 1까지 출력
		for(int i = 10; i>=0; i-=1) {
			System.out.println(i);
		}

	}

}
