package array2;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		//사용자에게 이름 5개를 입력받아서 배열 저장하고 출력하는 프로그램을 구현
		
		Scanner sc = new Scanner(System.in);
		String[] name = new String[5];
	
		//name[0] = sc.next();  1 2 3 4 
				
		for(int i=0; i < name.length; i++) {
			System.out.println("이름 입력 : ");
			name[i] = sc.next();
		}
		
		sc.close();
		
		for(int i=0; i < name.length; i++) {
			System.out.println("이름 : " + name[i]);
		}
	}

}
