package oop.keyword08;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		
		//static 과 final 을 같이 쓰는 이유
		
		// ex) 화면에 핸덤으로 가위/바위/보 중 하나가 출력
		// - 가위는 0  - 바위는 1  - 보는 2
		
		Random r = new Random();
		int rsp = r.nextInt(3);
		System.out.println("rsp = " + rsp);
		
		switch(rsp){
			case 0:
				System.out.println("가위");
				break;
			case 1:
				System.out.println("바위");
				break;
			case 2: //default:
				System.out.println("보");
				break;
		}
	}

}
        //주석이 없다면 가독성이 떨어짐 개선 필요
