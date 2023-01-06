package array2d;

public class Test03_2 {
	public static void main(String[] args) {
		
		//목표 : Test02를 2차원 배열로 변경
		
		//int[][] data = new int[2개][3칸];
		int[][] data = new int[][] {
			{10, 20, 30},
			{40, 50, 60}
		};		
//		int[] a = new int[] {10, 20, 30};
//		int[] b = new int[] {40, 50, 60};
		
//      구조
//		총괄리모컨     리모컨
//		data  --->  data[0]  --->  [10][20][30]
//			  --->  data[1]  --->  [40][50][60]
		
		System.out.println(data); //리모컨 대장(2차원)
		System.out.println(data[0]); //리모컨 부대장(1차원)
		System.out.println(data[1]); //리모컨 부대장(1차원)
		System.out.println(data[0][0]); //데이터
		
		System.out.println(data.length); // 2차원이 관리하는 1차원은 몇개? = 2개
		
		for(int i=0; i<=1; i++) {          // i <=1  1인 이유 data[0] data[1]  0,1  2개
			for(int k=0; k <= 2; k++) {    // k <=2  2인 이유 [10][20][30] 0,1,2  3개
				System.out.print(data[i][k]);
				System.out.print("\t");
			}
			System.out.println();
		}

	}

}
