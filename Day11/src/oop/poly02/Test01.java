package oop.poly02;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		
		//다형성 없이 풀이
		Scanner sc = new Scanner(System.in);
		System.out.println("(1:전사,2:마법사,3:궁수) 선택 : ");
		int job = sc.nextInt();
		
		System.out.println("(1:공격,2:이동,3:상점,4:정보) 선택 : ");
	    int action = sc.nextInt();
	    
	    sc.close();
	    
	    //다형성의 특징을 사용하지 않겠다는 것 = 자료형을 통합해서 쓰겠다는 것 (업캐스팅)
	    //Player Player = 전사객체 or 마법사객체 or 궁수객체
	    Player Player;
	    if(job == 1) {
	    	Player = new Warrior("전사");  //Warrior -> Player(업캐스팅)
	    }
	    else if(job == 2 ) {
	    	Player = new Magician("마법사");  //Magician -> Player(업캐스팅)
	    }
	    else {
	    	Player = new Archer("궁수");  //Archer -> Player(업캐스팅)
	    }
	    
	    System.out.println(Player);
	    
	    if(action == 1) {
	    	Player.attack();
	    }
	    else if(action == 2) {
	    	Player.move();
	    }
	    else if(action == 3){
	    	Player.market();
	    }
	    else {
	    	Player.output();
	    }
	  
	    
	}

}
