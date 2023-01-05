package array2;

public class Test11 {
	public static void main(String[] args) {
		
		//삽입정렬
		//1회차 의미X , 자리하나 지정 후 정렬
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		//int[] copy = new int[data.length];
		
//		1  0
//		2  1  0
//		3  2  1  0
//		4  3  2

		
		//처리
		for(int i=0; i<=3; i++) {
			if(data[i] > data[i+1]) {
				int backup = data[i];
				data[i] = data[i+1];
				data[i+1] = backup; 
			}
		}
		
		
		//출력
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
		}
	}


