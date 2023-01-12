package api.lang.object;

import java.util.Random;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		//Object가 진짜 최상위 클래스인지 확인
		// -> Object를 보관용도로 사용하면 "아무거나"라는 뜻과 같다.
		
		//boolean a = true;
		Object a = true;
		Object b = 10;
		Object c = 3.14;
		Object d = "Hello";
		
		//Scanner sc = new Scanner(System.in);
		Object sc = new Scanner(System.in);
		
		//Random r = new Random();
		Object r = new Random();
		
		//내가 만드것도 포함
		//Object s = new Student();
		
		//아무거나 10개 저장할 수 있는 배열
		Object[] arr = new Object[10];
	}

}
