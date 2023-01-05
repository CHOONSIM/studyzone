
package loop2;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		
		//숫자 모래성 게임

		//최초에 100이라는 값을 정해두고 사용자에게 숫자를 입력받아 차감을 합니다

		//계속적으로 입력받아 차감을 하다가 숫자가 음수가 되면 반복을 종료하고 게임 오버 메세지를 출력하세요

		//(+추가) 게임 오버 전까지 입력한 숫자의 개수를 출력해보세요 
		//(+추가) 사용자가 1부터 9 사이의 값만 입력할 수 있도록 처리해보세요
		
		//내 풀이
		int i = 100;
		int count = 0;
		
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("숫자 입력");
		    int n = sc.nextInt();
		    
		    i-=n;
	    	count++;
		   
		    if(n<=0 || n>=10) {
		    	System.out.println("1~9까지의 숫자를 입력하세요.");
		    }
		    if(i < 0) {
		    	break;
		    }
		    else {
		    	System.out.println("남은 숫자 : " + i);
		    }
		}
		
		sc.close();
		
		System.out.println("Game Over");
		System.out.println("입력 갯수 : " + count);
		
	}

}