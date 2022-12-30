package data2;
import java.lang.*;

public class Test04 {
	public static void main(String[] args) {
		//목표 : 지하철 무임승차 대상인지 판정
		// -영유아(7세 이하)
		// -노인(65세 이상)
		
		//입력
		int age = 64;
		
		//처리
		//boolean free = 7세 이하이거나(또는) 65세 이상;
		//boolean free = age <= 7 또는 age >= 65;
		boolean free = age <= 7 || age >= 65;
		
		//출력
		System.out.println(free);
	}

}
