package array2d;

import java.util.Random;

public class Test05_2 {
	public static void main(String[] args) {
		
//		빙고판 만들기
//
//		5x5 빙고판을 만들려고 합니다
//
//		2차원배열을 만들고 1부터 25까지 겹치는 자리가 없이 모두 배치되도록 구현
//
//		다 만들었으면 빙고판을 화면에 출력
		
		Random r = new Random();
		int size = 5;
		int[][]data = new int[size][size];
		
		//초기화(1부터 25까지)
		for(int i=1; i<= size*size; i++) {
			
			int row = r.nextInt(size); //int row = 0,1,2,3,4;
			int col = r.nextInt(size); //int col = 0,1,2,3,4;
			
			//System.out.println("(?,?) 위치에" + ? +"를 넣습니다.");
			//System.out.println("("+row+","+col+") 위치에" + i +"를 넣습니다.");
			
			if(data[row][col]==0) { //한번도 데이터를 널은적이 없는 칸일 경우
			data[row][col] = i;
			}
			else {
				i--; //반복 무효화(재추첨)
			}
		}
		//겹침 
		
		
		
		System.out.println(data.length);
		
		for(int i=0; i < size; i++) {
			for(int k=0; k < size; k++) {
				System.out.print(data[i][k]);
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}
		//랜덤
		
		
	}

}
