package api.lang.string;

import java.util.Scanner;

public class Test06_1 {
	public static void main(String[] args) {
		
		//반복문 사용
		
		String[]filter = new String[] {
				"신발", "수박", "십장생", "변신", "주옥", "시베리아", "개나리", "잣"
		};

		
		
		String line = "개나리 신발끈 십장생 주옥같은 경우를 봤나";
		
		for(int i=0; i < filter.length; i++) {
			line = line.replace(filter[i], "*");
		}
		
		System.out.println(line);

	}

}
