package array2d;

import java.util.Random;

public class Test06 {
	public static void main(String[] args) {
		
		
//		지뢰찾기 만들기
//
//		지뢰찾기를 다음 요구사항에 맞게 구현
//
//		1.9x9 배열을 준비(초급자)
//		2.랜덤으로 10개의 폭탄을 지도에 배치(폭탄은 숫자 9로 설정)
//		3.지도 출력
//		4.폭탄이 아닌 칸의 숫자를 계산(선택)
//		  폭탄이 배치되지 않은 칸들을 반복하며 계산
//		  기준 칸 주변 8칸을 조사하여 폭탄의 개수를 카운트
//		  카운트된 숫자를 현재 위치에 대입
//		5.최종 지도 출력(선택)
		
		
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
