package loop;

import java.util.Scanner;

public class Test05_3 {

	public static void main(String[] args) {
		//사용자에게 '분','초'를 입력받는다
		//입력받은 시간부터 0분 0초까지 반복적으로 1초씩 감소하도록 출력
		//모든 출력을 마치고 '시간이 다 되었습니다' 출력
		
		//분 입력 :2
		//초 입력 :30
		
		//문제 풀이-3
        Scanner sc = new Scanner(System.in);
		
		System.out.println("분 입력");
		int minute = sc.nextInt();
		
		System.out.println("초 입력");
		int second = sc.nextInt();
		
		sc.close();
		
		
		int time = minute * 60 + second;
		//System.out.println("time = " + time);
		
		for(int i=time; i>0; i--) {
			int min = i / 60;
			int sec = i % 60;
			System.out.println(min+"분 "+sec+"초 후 알람이 울립니다");
			
			// 1초간 중지시킨다.(단위 : 밀리세컨드)
			// Thread.sleep(1000);
		}
		
		System.out.println("시간이 다 되었습니다!");
		

	}

}
