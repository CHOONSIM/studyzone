package loop2;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		//사용자에게 숫자를 지속적으로 입력받아 입력받은 숫자의 총 합계와 평균을 출력
		//단, -1이 입력된 경우 프로그램 종료
		
		Scanner sc = new Scanner(System.in); 
		
		int total = 0;
		int count = 0;
		
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int n = sc.nextInt();
			
			if(n == -1) {             //{}가 없어도 한개의 구문으로 인식함
				break;
			}
			else {
				total += n;
				count++;
			}
		}
		sc.close();
		
		System.out.println("count : " + count);
		System.out.println("total : " + total);
		double average = (double)total / count;
		System.out.println("average : " + average);
		//System.out.println("평균 : " + average);
	}

}
