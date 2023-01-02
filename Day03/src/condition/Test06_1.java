package condition;
//import java.lang.*;
public class Test06_1 {
	public static void main(String[] args) {
		
		//과제 풀이
		
		//입력
		int inHour = 10, inMinute = 0;
		int outHour = 11, outMinute = 10;
		
		int period = 60;//기본 요금 적용 시간(분)
		int basePrice = 5000;//기본 요금(원)
		int term = 10;//요금이 변경되는 시간 간격(분)
		int termPrice = 500;//구간당 추가요금(원)
		
		//처리
		int inTime = inHour * 60 + inMinute;
		int outTime = outHour * 60 + outMinute;
		int time = outTime - inTime;
		//System.out.println(time);
		
		int hour = time / 60;
		int minute = time % 60;
		
//		int price = 5000원 or 5000원+추가요금;
		int price;
		if(time < period) {//이용시간이 1시간 이내라면(~59분까지)
			price = basePrice;
		}
		else {//1시간이 넘어간 경우
			int plus = (time - period) / term * termPrice + termPrice;
			price = basePrice + plus;
		}
		
		//출력
		System.out.println("이용시간");
		System.out.println(hour);
		System.out.println(minute);
		System.out.println("이용요금");
		System.out.println(price);
	}
}