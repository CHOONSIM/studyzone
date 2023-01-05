package array2;

public class Test08 {
	public static void main(String[] args) {
		
//		5명의 키가 다음과 같을 때 가장 키가 큰 사람의 위치와 값을 출력
//		데이터 : [150.8, 180.2, 175.9, 162.7, 170.3]
		
		double[] height = new double[] {150.8, 180.2, 175.9, 162.7, 170.3};
		
//        최대값과 최대값의 위치(index) 찾기
//        기대하는 결과 : index = 1 , max = 180.2
		
		
		double max = height[0];
		
		for(int i = 1; i<height.length; i++) {  //남은 애들과 비교
			if(max < height[i]) {               //더 큰 데이터가 발견된다면
			   max = height[i];                 //max를 바꾼다
			}
		}
		
		System.out.print("제일 큰 키 = " + max);
		System.out.print(" ");
	}

}
