package oop.keyword07;

public class Calculator {
	
	public static int cal(int number) {
		return number * number;
	}
	
//	public static int square(int origin, int value) {
//		int result = 1;
//		for(int i=0; i < value; i++) {
//			result *= origin;
//		}
//		return result;
//	}
	
	
	public static double cal1(double height, double weight) {
		double heightMeter = height /100;
		return weight / (heightMeter * heightMeter);
	}
	
	public static int cal2(int birth) {
		int year = 2023;
		int age = year - birth +1;
		if(age < 8 || age>= 65) return 0;
		else if(age>=20) return 1250;
		else if(age>=14) return 720;
		else return 450;

	}
	
	public static double cal3(double under , double elevation) {
		return under * elevation/2;
	}
	
	public static double cal4(double radius) {
		return radius * radius * 3.14;
	}
	

}
