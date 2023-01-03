package loop;

public class Test01 {

	public static void main(String[] args) {
		//반복
		// ex) Hello!를 10번 출력하세요.
		//10번
		//10개를 다 사용할 떄까지
		//for(i라는 통에 공이 1개 들어가있다; 10개이하이면 실행; 1개씩 증가)
		//          선언부                  조건부         증감부
		
		for(int i=1; i<= 10; i++) {                   //10개
			System.out.println("Hello!");
		}
		for(int i=0; i < 10; i++) {                   //10개
			System.out.println("Hello!");
		}

		for(int i=1; i<= 10; i+=1) {                  //11개
			System.out.println("Hello!");
		}


	}

}
