package data;
import java.lang.*;

public class Test07 {
	public static void main(String[] args) {
	
		int hourA = 3;
		int minA = 50;
		int hourB = 4;
		int minB = 25;
		
		int timeA = hourA * 60 + minA; 
		int timeB = hourB * 60 + minB; 
		int total = timeA + timeB;
		
		int totalTimehour = total / 60; 
		int totalTimemin = total % 60; 
		
		System.out.print(totalTimehour + " 시"); System.out.print(totalTimemin + " 분");
		
	}

}
