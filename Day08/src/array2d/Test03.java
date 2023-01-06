package array2d;

public class Test03 {
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
		
		System.out.println(data); //리모컨 대장
		System.out.println(data[0]); //리모컨 부대장
		System.out.println(data[1]); //리모컨 부대장
		System.out.println(data[0][0]); //데이터
		
		for(int k=0; k <= 2; k++) {
			System.out.print(data[0][k]);
			System.out.print("\t");
		}
		System.out.println();
		
		for(int k=0; k <= 2; k++) {
			System.out.print(data[1][k]);
			System.out.print("\t");
		}

	}

}
