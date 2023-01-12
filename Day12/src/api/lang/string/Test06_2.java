package api.lang.string;

import java.util.Scanner;

public class Test06_2 {
	public static void main(String[] args) {
		
		//반복문 사용 + 글자수대로 변경
		
		
		
		String[]filter = new String[] {
				"신발", "수박", "십장생", "변신", "주옥", "시베리아", "개나리", "잣"
		};

		
		Scanner sc = new Scanner(System.in);
		System.out.print("대화 입력 : ");
		String line = sc.nextLine();
		sc.close();
		
		
		for(int i=0; i < filter.length; i++) {
			int size = filter[i].length();
			String star = "*".repeat(size);  
			line = line.replace(filter[i],star);
		}
		
		System.out.println("대화 출력 : " + line);

	}

}