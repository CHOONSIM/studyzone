package loop;

import java.util.Scanner;

public class Test09 {

	public static void main(String[] args) {
		
//		소수 찾기 프로그램
//		소수는 자기자신과 1을 제외한 나머지 나눗셈이 불가능한 숫자를 말합니다
//		예를들어 2,3,5,7과 같은 숫자를 말합니다.
//      사용자가 어떤 숫자를 입력했을 때, 이 숫자가 소수인지 아닌지 출력
		
		
		
		//내 풀이
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
	    int num = sc.nextInt();
	    sc.close();
	    
	    int count = 0;
	    //처리
	    for(int i=1; i<=num; i++) {  //1과 자기 자신을 없애면 처리속도 증가
	    	System.out.println(i + "로 나눈 나머지 = " + num % i);
	    	if(num % i==0) {
	    		//System.out.println(num % i); //0찾기 
	    		count++;  //0개수 찾기 0이 두개면 소수
	    		
	    	    break; //나머지 0인경우가 발견되면 바로 종료
	    	}
	    }
	    System.out.println("나누어 떨어지는 숫자 개수 = " + count);
	    	
	    
	    //출력
	    if(count == 2){              //1과 자기 자신을 없애면 0의 갯수는 0
	    	System.out.println("소수입니다.");
	    }
	    else {
	    	System.out.println("소수가 아닙니다.");
	    }
	    
	}

}