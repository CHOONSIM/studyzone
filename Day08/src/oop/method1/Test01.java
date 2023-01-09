package oop.method1;

public class Test01 {
	public static void main(String[] args) {
		
		CellphoneFee c1 = new CellphoneFee();
		CellphoneFee c2 = new CellphoneFee();
		CellphoneFee c3 = new CellphoneFee();
		
		c1.setting("SK", "5G언택트52", 52000, 200, 1000, 2000);
		c2.setting("KT", "5G세이브  ", 45000, 100, 900, 1500);
		c3.setting("LG", "5G시그니처  ", 130000, 500, 2000, 2500); 
		
		System.out.println();
		
		c1.output();
		System.out.println();
		c2.output();
		System.out.println();
		c3.output();
		
	}

}
