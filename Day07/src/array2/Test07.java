package array2;

public class Test07 {
	public static void main(String[] args) {
		
		//목표 : 최소값 , 최대값 찾기
		// - 데이터는 왼쪽(+0)부터 살펴본다
		// - 맨 앞(+0) 데이터가 가장 작다고 생각하고 시작
		// - 뒤의 데이터와 비교해서 더 작은 데이터를 찾으면 최소값, 더 큰 데이터를 찾으면 최대값
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//1. 맨앞 데이터가 가장 작다고 가정
		int min = data[0];  
		
		for(int i=1; i<data.length; i++){//남은 애들과 비교
			if( min > data[i]) {  //더 작은 데이터가 발견된다면
				min = data[i];//min을 해당 데이터로 수정
			}
		
		}
		
		System.out.println("최소값 = " + min);

	
	}
	

}
