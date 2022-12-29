package data;
import java.lang.*;

public class Test05 {
	public static void main (String[] args) {
		int jjajangPrice = 6000;
		int jjamPrice = 7500;
		
		int jjajangCount = 5;
		int jjamCount = 3;
		
		int jjajangTotal = jjajangPrice * jjajangCount;
		int jjamTotal = jjamPrice * jjamCount;
		
		int total = jjajangTotal + jjamTotal;
		
		System.out.println("총 "+ total + "원" + " 입니다.");
		
	}
	

}
