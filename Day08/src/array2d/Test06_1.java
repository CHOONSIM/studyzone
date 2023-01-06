package array2d;

import java.util.Random;

public class Test06_1 {
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
