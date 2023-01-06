package array2d;

import java.util.Random;

public class Test06_1 {
	public static void main(String[] args) {
		
		
		
		
		int row = 9; //줄수
		int col = 9; //칸수
		int bomb = 10; //폭탄 개수
		
		//지도생성
		int[][]map = new int[row][col];
		
		//폭탄배치
		
		Random r = new Random();
		for(int i=0; i < bomb; i++) {
			int x = r.nextInt(row); // + 0;
			int y = r.nextInt(col); // + 0;
			if(map[x][y] == 0){
				map[x][y] =9;
			}
			else {
				i--;
			}
		}
		
		//출력
		for(int i=0; i < row; i++) {
			for(int k=0; k < col; k++) {
				System.out.print(map[i][k]);
				System.out.print(" ");
				
			}
			System.out.print("\n");
		}
		
	}

}
