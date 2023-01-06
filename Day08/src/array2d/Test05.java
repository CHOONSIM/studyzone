package array2d;

import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
		
//		빙고판 만들기
//
//		5x5 빙고판을 만들려고 합니다
//
//		2차원배열을 만들고 1부터 25까지 겹치는 자리가 없이 모두 배치되도록 구현
//
//		다 만들었으면 빙고판을 화면에 출력
		
		int[][]data = new int[5][5];
		
		//Random r = new Random();
		
		System.out.println(data.length);
		
		for(int i=0; i < data.length; i++) {
			for(int k=0; k < data[i].length; k++) {
				System.out.print(data[i][k]);
				System.out.print("\t");
			}
			System.out.println();
		}
		//랜덤
		
		
	}

}
