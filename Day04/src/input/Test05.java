package input;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		//사용자에게 국어 영어 수학 점수를입력받고 총점과 평균 합격여부를 계산하여 출력
		//합격이란 각 과목이 40점 이상 평균 60점 이상
		
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요");
		double korean = sc.nextDouble();
		System.out.println("영어 점수를 입력하세요");
		double english = sc.nextDouble();
		System.out.println("수학 점수를 입력하세요");
		double math = sc.nextDouble();
		sc.close();
		
		double total = korean + english + math;
		
		//double average = total / 3.0;
		double average = (double)total / 3; //권장하는 방식
		//double average = total / 3d;
		
		//boolean pass = korean >= 40 && english >= 40 && math >= 40 && average >=60;
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + average);
		
		if(average >= 60 && korean >= 40 && english >= 40 && math >= 40) {
			System.out.println("합격입니다.");
		}
		else {
			System.out.println("불합격입니다.");
		}
		
	}
}
