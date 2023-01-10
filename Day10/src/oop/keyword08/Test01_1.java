package oop.keyword08;

import java.util.Random;

public class Test01_1 {
	public static void main(String[] args) {
		
	   //메소드 안에 있어서 불가능
		
		final int scissors = 0;
		final int rock = 1;
		final int paper = 2;
		
		Random r = new Random();
		int rsp = r.nextInt(3);
		System.out.println("rsp = " + rsp);
		
		switch(rsp){
			case scissors:
				System.out.println("가위");
				break;
			case rock:
				System.out.println("바위");
				break;
			case paper: //default:
				System.out.println("보");
				break;
		}
	}

}
        //주석이 없다면 가독성이 떨어짐 개선 필요
