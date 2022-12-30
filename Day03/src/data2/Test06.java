package data2;
import java.lang.*;

public class Test06 {

	public static void main(String[] args) {
		// 어떤 두 자리의 숫자가 주어져 있을 때, 이 숫자에 7이 포함되어 있는지 판정하여 출력
        // ex) 51(false) , 72(true) , 77(true)
		
		//내 풀이
		//입력
		int number = 51;
		
		//처리
		boolean A = number / 10 == 7;
		boolean B = number % 10 == 7;
		
	    System.out.println(A);
	    System.out.println(B);
		
		boolean answer = A || B;
		
		System.out.println(answer);
		
		//과제 풀이
		//입력
		int n = 51;
		
		//처리
		int ten = n / 10;
		int one = n % 10;
		
		boolean has7 = ten == 7 || one == 7;
		
		//출력
		System.out.println(has7);
	}

}
