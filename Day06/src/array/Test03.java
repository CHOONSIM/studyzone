package array;

public class Test03 {
	public static void main(String[] args) {
//		다음 데이터를 저장하고, 문제에서 요구하는 내요을 구현하세요.
//		- 데이터 : 33 , 45 , 31 , 54 , 67 , 36 , 39
//		
//		요구사항
//		1. 모든 데이터 출력
//		2. 짝수 데이터 출력
//		3. 50이 넘는 데이터 개수 출력
//		4. 모든 데이터 합계 출력
//		5. 모든 데이터 평균 출력
		
		int []data = new int[] {33 , 45 , 31 , 54 , 67 , 36 , 39};
		//int []data = {33 , 45 , 31 , 54 , 67 , 36 , 39};
		//int data[] = new int[] {33 , 45 , 31 , 54 , 67 , 36 , 39};
		
		
		System.out.println(data.length);
		
		//1. 모든 데이터 출력
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
		
		System.out.println();
		
//		2. 짝수 데이터 출력
		for(int i=0; i<data.length; i++) {
			if(data[i] % 2 == 0) {
				System.out.println("짝수 = "+data[i]);
			}
			else {
			}
		}
		
		System.out.println();
		
//		3. 50이 넘는 데이터 개수 출력
		int count = 0;
		for(int i=0; i<data.length; i++) {
			if(data[i] >50) {
				
				//System.out.println("50이 넘는 수 = "+data[i]);
				count++;
			}
		}
		System.out.println("50이 넘는 수의 개수 = "+count);
		
		
		System.out.println();
		
//		4. 모든 데이터 합계 출력, 평균 출력
		int total = 0;
		for(int i=0; i<data.length; i++) {
			total += data[i];
		}
		System.out.println("total = "+ total);
		double average = (double)total / data.length; //cast연산 
		System.out.println("average = " + average);
		
		
	}

}
