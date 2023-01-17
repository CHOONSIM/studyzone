package api.util.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("나라 이름 입력 : "); 
			String country = sc.nextLine();
			
			if(list.contains(country)) {
				System.out.println("game over");
				break;
			}
			else {
				list.add(country);
				System.out.println(list);				
			}
		}
		
		sc.close();
		
//		전체 출력
		System.out.println("입력한 나라 : ");
		for(String country : list) {
//		for(int i=0; i<list.size(); i++) {
			System.out.print("->");
			System.out.println(country);
		}
			
			
		}
		
		}
		
	


