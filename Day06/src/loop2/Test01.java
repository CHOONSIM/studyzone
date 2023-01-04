package loop2;

public class Test01 {
	public static void main(String[] args) {
		//목표 : while 반복문 만들기
		// Q) 1부터 10까지 출력
		
		//for 사용
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		int n = 1;
		while(n<=10) {
			System.out.println(n);
			n++;
		}
	}

}
