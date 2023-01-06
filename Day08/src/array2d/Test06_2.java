package array2d;

import java.util.Random;

public class Test06_2 {
	public static void main(String[] args) {
		//번외 : 지뢰찾기 풀버전
		int row = 9;
		int col = 9;
		int bomb = 10;
		
		int[][] map = new int[row][col];
		
		//폭탄 배치
		Random r = new Random();
		for(int i=0; i < bomb; i++) {
			int x = r.nextInt(row);
			int y = r.nextInt(col);
			if(map[x][y] == 0) {
				map[x][y] = 9;
			}
			else {
				i--;
			}
		}
		
		//숫자 계산
		for(int i=0; i < row; i++) {
			for(int k=0; k < col; k++) {
				if(map[i][k] == 9) {
					System.out.println("("+i+","+k+")에는 폭탄이 있어서 숫자를 계산하지 않습니다");
					continue;
				}
				
				System.out.println("("+i+","+k+")의 숫자를 계산합니다");
				System.out.println("-> 계산을 위한 범위를 정합니다");
				int xmin, xmax, ymin, ymax;
				//지도 가장자리 칸인지 아닌지에 따라 조건을 부여하여 범위를 다르게 설정
				if(i==0) 		xmin = 0; 		else xmin = i-1;
				if(i==row-1) 	xmax = row-1; 	else xmax = i+1;
				if(k==0) 		ymin = 0; 		else ymin = k-1;
				if(k==col-1) 	ymax = col-1; 	else ymax = k+1;
				System.out.println("\t-> 검사 범위 : ("+xmin+","+ymin+")부터 ("+xmax+","+ymax+")까지");
				
				int count = 0;
				for(int x=xmin; x<=xmax; x++) {
					for(int y=ymin; y<=ymax; y++) {
						if(i==x && k==y) {
							System.out.println("\t\t-> ("+x+","+y+")는 기준 위치이므로 건너뜁니다");
							continue;
						}
						
						if(map[x][y] == 9) {
							count++;
							System.out.println("\t\t-> ("+x+","+y+")에는 폭탄이 있습니다.. 총 "+count+"개 찾음");
						}
						else {
							System.out.println("\t\t-> ("+x+","+y+")에는 폭탄이 없습니다");
						}
					}
				}
				System.out.println("\t-> ("+i+","+k+") 위치의 숫자는 "+count+"로 계산되었습니다");
				map[i][k] = count;
			}
		}
		
		//출력
		for(int i=0; i < row; i++) {
			for(int k=0; k < col; k++) {
				if(map[i][k] == 9) {
					System.out.print("*");
				}
				else if(map[i][k] > 0) {
					System.out.print(map[i][k]);
				}
				else {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}