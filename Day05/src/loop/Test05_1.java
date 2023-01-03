package loop;

public class Test05_1 {

	public static void main(String[] args) {
		//사용자에게 '분','초'를 입력받는다
		//입력받은 시간부터 0분 0초까지 반복적으로 1초씩 감소하도록 출력
		//모든 출력을 마치고 '시간이 다 되었습니다' 출력
		
		//분 입력 :2
		//초 입력 :30
		
		//문제 풀이-1
		int minute = 2;
		int second = 30;
		
		int time = minute * 60 + second;
		System.out.println("time = " + time);
		
		for(int i=time; i>0; i--) {
			int min = i / 60;
			int sec = i % 60;
			System.out.println(min+"분 "+sec+"초 후 알람이 울립니다");
		}
		
		System.out.println("시간이 다 되었습니다!");

	}

}
