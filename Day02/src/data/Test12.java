package data;
import java.lang.*;

public class Test12 {
	public static void main(String[] args) {
		//목표 : 정수와 실수간의 변환이 되는가? (형변환)
		int a = 10;
		double b = a; // int -> double (자동 변환)
		System.out.println(b); 
		
		double c = 1.5;
		//int d = c; error
		int d = (int)c; //double -> int (강제 변환)
	    System.out.println(d);
	    
	    //(중요) 어떠한 경우에도 실수(double)가 정수(int)보다 크다
	    
	   
	}

}
