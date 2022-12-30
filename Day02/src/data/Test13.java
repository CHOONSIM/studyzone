package data;
import java.lang.*;

public class Test13 {
	public static void main(String[] args) {
		//pc방 요금이 한시간에 1300원
		//오전 9시 50분부터 오후 1시 35분까지 이용한 고객의 요금을 출력
		//단, 십원 단위는 받지 않습니다.(99원까지는 할인 처리)
		
		//내풀이
		int pcCharge = 1300;
		int pcHour1 = 9;  int pcMin1 = 50;
		int pcHour2 = 13; int pcMin2 = 35;
		
		int pcTime1 = pcHour1 * 60 + pcMin1;
		int pcTime2 = pcHour2 * 60 + pcMin2;
		
		int totalTime =  pcTime2 - pcTime1;  //225
		
		int totalHour = totalTime / 60;
		int totalMin = totalTime % 60; 
		
		//System.out.print(totalHour + " 시간");
		//System.out.print(totalMin + " 분");
		
		double minCharge = pcCharge / 60;
		double pcCharge1 = totalTime * minCharge;
		//System.out.println(minCharge);
		//System.out.println(pcCharge1);
		
		double pcCharge2 = pcCharge1 * 0.01;
		//System.out.println(pcCharge2);
		int pcCharge3 = (int)pcCharge2;
		//System.out.println(pcCharge3);
		int totalCharge = pcCharge3 * 100;
		
		System.out.println(totalCharge);  
	}

}
