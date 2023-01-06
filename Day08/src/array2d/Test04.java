package array2d;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		
//		다음 데이터를 저장하고 문제를 푸세요
//
//		[90][80][85][77]
//		[60][85][73][92]
//		[50][70][70][80]
//		모든 데이터를 표 형식으로 출력
//		모든 데이터 평균 출력
		
		//1.모든 데이터를 표 형식으로 출력
		int[][] data = new int[][] {
			{90, 80, 85, 77},
			{60, 85, 73, 92},
			{50, 70, 70, 80}
		};
		
		System.out.println(data.length);
		
		for(int i=0; i<data.length; i++) {
			for(int k=0; k<data[i].length; k++) {
				System.out.print(data[i][k]);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		
		//2.평균 출력
		
//		total += data[0][0];
//		total += data[0][1];
//		total += data[0][2];
//		total += data[0][3];
//		.
//		.
//      .
		
		int total = 0;
		int count = 0;
		for(int i=0; i<data.length; i++) {
			for(int k=0; k<data.length; k++){
				total += data[i][k];
				count++;
			}
		}
		//double average = total / (data.length * data[0].length);
		double average = (double)total / count; 
		System.out.print(average);
		
		System.out.println();
		
		//3. 랜덤으로 값 1개를 배열 중에서 출력
		//  (가로 위치 세로 위치) 랜덤 위치 하나씩 찾아줘야함
		Random r = new Random();
		
		int row = r.nextInt(data.length); //int row = r.nextInt(3); //int row = r.nextInt(3)+0;
		int col = r.nextInt(data[row].length); //int col = r.nextInt(2)+0;
		
		int choice = data[row][col];
		System.out.print("choice = "+choice);
		
		
	}

}
