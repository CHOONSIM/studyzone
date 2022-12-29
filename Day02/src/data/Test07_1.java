package data;
import java.lang.*;

public class Test07_1 {
	public static void main(String[] args) {
		
		//
		//
		//
		//
		//
		//복잡한 방법
		
		int hourA = 3;
		int minA = 50;
		int hourB = 4;
		int minB = 25;
		
		int hour = hourA +hourB;
		int min = minA + minB;

		int fixHour = min / 60;
		int fixMin = min % 60;

		int finalHour = hour + fixHour;
		int finalMin = fixMin;

		System.out.print(finalHour + " 시"); System.out.print(finalMin + " 분");

	}

}
