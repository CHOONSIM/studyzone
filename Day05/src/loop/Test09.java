package loop;

public class Test09 {

	public static void main(String[] args) {
		
//		소수 찾기 프로그램
//		소수는 자기자신과 1을 제외한 나머지 나눗셈이 불가능한 숫자를 말합니다
//		예를들어 2,3,5,7과 같은 숫자를 말합니다.
//      사용자가 어떤 숫자를 입력했을 때, 이 숫자가 소수인지 아닌지 출력
		
		
		
		//내 풀이
	
		int num =1;
		
		for(int i=3; i<=num; i++) {
			for(int j = 2; j<i; ++j) {
				if(i/j == 0) {
					System.out.println("소수가 아닙니다.");
				}
				else {
					System.out.println("소수입니다.");
				}
			}
			
		}
		
		
	}

}
