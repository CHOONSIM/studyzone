package loop;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("분을 입력하세요.");
		int minute = sc.nextInt();
		System.out.println("초를 입력하세요.");
		int second = sc.nextInt();
		
		sc.close();
		
		int total = minute*60+second;
		
		for(int i=total; i>0; i-- ) {
			int min = i / 60;
			int sec = i % 60;
			System.out.println(min +"분" + sec + "초 후 알람이 울립니다.");
			
			//1초간 중지시킨다.(단위 : 밀리세컨드)
			// Thread.sleep(1000);
		}
		System.out.println("시간이 다 되었습니다!");
	}

}
