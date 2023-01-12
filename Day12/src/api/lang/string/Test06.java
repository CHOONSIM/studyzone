package api.lang.string;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {

		String line = "개나리 신발끈 십장생 주옥같은 경우를 봤나";
		
		//ex) 신발 하나만 욕설로 처리
		line = line.replace("신발","**");
		
		
		
		System.out.println(line);	
		
		
	}

}
