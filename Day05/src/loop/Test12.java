package loop;

import java.util.Scanner;

public class Test12 {
	public static void main(String[] args) {
		//사용자가 원하는 구구단을 출력하는 프로그램을 구현하세요

		//(+추가) 다 만드셨다면 정답 부분을 사용자가 입력하게 만들어 정답/오답 판정이 가능하게 하세요

		//괄호 친 부분은 사용자가 입력하는 부분입니다
		//원하는 구구단 : (5)

		//5 x 1 = (5)
		//정답!
		//5 x 2 = (9)
		//오답!
		//...
		//5 x 9 = (45)
		//정답!

		//정답 개수 : 2
		Scanner sc = new Scanner(System.in);
		
		System.out.println("원하는 구구단을 입력");
		int n = sc.nextInt();//단
		int i;
		int respone; //답입력값
		int answer; //정답
		int correct = 0;
		int wrong = 0;
		int combo = 0;
		
		long start = System.currentTimeMillis();// 현재시각을 숫자로 측정 , 반복문 시작할때 끝날때
	
		for(i = 1; i <10; i ++) {
			//구구단 처리
			System.out.print(n + "x" + i + "=");
			
			respone=sc.nextInt();
			answer=i*n;
			if(respone==answer) {
				System.out.println("정답!");
				correct++; // 맞출시 정답갯수
				combo++; //연속으로 맞출 시
				if(combo >=2) { //2개이상 맞출시 콤보 출력 , 틀리면 리셋
					System.out.println(combo + "combo");  
				}
			}
			else {
				System.out.println("오답!");
				i--; // 틀리면 다시 풀기 , 늘어난만큼 빼기 
				wrong++; //틀린 개수
			}
		}
		long finish = System.currentTimeMillis();
		
		//System.out.println("start = " + start);
		//System.out.println("finish = " + finish);
		System.out.println(finish - start); //소요시간 , 밀리초(ms) (1000밀리초=1초)
		double time = (double)(finish - start) /1000; // long-long / int 불가능  long-long앞에 (double) 입력 
		
		sc.close();
		
		System.out.println("정답 개수 : " + correct); 
		System.out.println("틀린 개수 : " + wrong);
		System.out.println("소요 시간 : " + time + "s"); //소요시간
	}

}