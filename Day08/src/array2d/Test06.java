package array2d;

import java.util.Random;

public class Test06 {
	public static void main(String[] args) {
		
		
		
		//내 풀이
		
		Random r = new Random();
		
		int size = 9;
		int[][]mine = new int[size][size];
		int bomb = 9;
		int mineNum = 10;
		
		for(int i=0; i<=size*size; i++) {
			
			int row = r.nextInt(bomb);
			int col = r.nextInt(bomb);
			System.out.println("("+row+","+col+") 위치에" + bomb +"를 넣습니다.");
			
			if(mine[row][col] == bomb) {
				i--;
			}
			else {
				
				
			}
		

			
		}
		
System.out.println(mine.length);
		
		for(int i=0; i < size; i++) {
			for(int k=0; k < size; k++) {
				System.out.print(mine[i][k]);
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}
	}

}
