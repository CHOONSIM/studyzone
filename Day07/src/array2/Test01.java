package array2;

public class Test01 {
	public static void main(String[] args) {
		
		//목표 : int가 아닌 다른 데이터 배열
		
		//1. 실수 5개를 저장하는 배열 double
		double[] data = new double[5];
		//data = [0.0][0.0][0.0][0.0][0.0]
		double[] data1 = new double[] {1.1 , 2.2 , 3.3 , 4.4 , 5.5};
		//data1 = [1.1][2.2][3.3][4.4][5.5]
		
		
		//2. 문자열 5개를 저장하는 배열(값을 모를때)
		//(참고) null은 참조변수(리모컨)의 대상이 존재하지 않음을 의미(본체없음)
		String[] data2 = new String[5];
		//data2 = [null][null][null][null][null]
		
		for(int i=0; i<data2.length; i++) {
		System.out.println(data2[i]);
		}
		
		//3."자바" , "파이썬" , "C++" , "루비" , "안드로이드" 를 배열에 저장 
		String[] data3 = new String[] {
		 "자바" , "파이썬" , "C++" , "루비" , "안드로이드"
		};
		for(int i=0; i<data3.length; i++) {
		System.out.println(data3[i]);
		}
	}

}
