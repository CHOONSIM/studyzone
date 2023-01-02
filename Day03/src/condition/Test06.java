package condition;
import java.lang.*;

public class Test06 {
	public static void main(String[] args) {
		//kh주차장은 다음과 같이 주차요금을 계산합니다.
		//입장 시 1시간은 기본요금 5000원
		//1시간 이후부터는 10분당 500원으로 계산
		//입력값으로 들어온 시각/분, 나간 시각/분을 설정하고 주차요금을 계산하여 출력
		
		//내 풀이
		
		//입력
		int parkingFee = 5000;
		int parkingFeePerMin = 500;
		int parkingFeeTime = 60;
		int extraFeeTime = 10;
		int inHour = 11;  int inMin = 00;
		int outHour = 12; int outMin = 01;
		
		//처리
		int inTime = inHour * 60 + inMin;
		int outTime = outHour * 60 + outMin;
		int parkingTime = outTime - inTime; //총시간
		//System.out.println(parkingTime);
		int hour = parkingTime / 60;
		int min = parkingTime % 60;
		
		System.out.print(hour + "시간");
		System.out.println(min + "분 사용");
		
		boolean fee1 = parkingTime <= 60;
		
		//출력
		if(fee1){
			System.out.println(parkingFee + " 원 입니다.");
		}
		else{
			System.out.println((parkingTime-parkingFeeTime) * parkingFeePerMin + parkingFee + " 원 입니다.");
		}
		
	}

}