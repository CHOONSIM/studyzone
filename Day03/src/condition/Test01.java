package condition;
import java.lang.*;

public class Test01 {
	public static void main(String[] args) {
		//조건
		
		//입력
		int age = 20;
		
		//처리
		boolean adult = age >= 20;
		
		//출력
		//if(adult가 true면)
		//if(adult == true) true면 생략
		if(adult){
			System.out.println("성인입니다.");
		}
		//if(adult == false) !로 false 생략
		if(!adult){
			System.out.println("성인이 아닙니다.");
		}
	}

}
