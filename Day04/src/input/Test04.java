package input;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		//과거에 풀었던 BMI 계산기를 사용자 정보를 입력받아서 계산하도록 변경
		//입력 항목 : 신장(cm), 체중(kg)
		//BMI지수가 24.5 이상이라면 과체중, 이하라면 정상을 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("신장 입력");
		double height = sc.nextDouble();
		System.out.println("체중 입력");
		double weight = sc.nextDouble();
		sc.close();
		
		double heightM = height / 100;
		
		double BMI = weight / (heightM * heightM);
		
		System.out.println("BMI = " + BMI);
		if(BMI >= 24.5) {
			System.out.println("과체중입니다.");
		}
		else{
			System.out.println("정상체중입니다.");
		 }
		}

	}


