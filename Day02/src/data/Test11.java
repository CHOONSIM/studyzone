package data;
import java.lang.*;

public class Test11 {
	public static void main(String[]args) {
		//BMI (체질량지수) 계산기
		//네이버에서 BMI계산기 검색 참고
		//해당 프로그램에서 성별,나이를 제거하고 만들 예정
		//키가 180cm, 체중 80kg 이 사람의 BMI 지수
		//               체중(kg)
		//계산 공식 = -------------------
		//               키제곱(m2)
		
		//내 풀이
		//int height = 180;
		//int weight = 80;
		
		//double heightM = height / 100.0;
		//double heightBMI = heightM * heightM;
		//double BMI = weight / heightBMI; 
		
		//System.out.println(BMI);
		
		//입력
		double cm = 180;
		double kg = 80;
		
		//처리
		double m = cm / 100;
		
		//double bmi = kg/m2;      없 음
		//double bmi = kg/m^2;     error
		//double bmi = kg/ m * m;  값이 달라짐
		double bmi = kg / (m*m);
		
		//출력
		System.out.println(bmi);
	
	}

}
