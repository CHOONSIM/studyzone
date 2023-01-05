package array2;

public class Test10 {
	public static void main(String[]args) {
	
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//버블정렬
		
		//처리
		// - 선택정렬 1회차 : 0~1에서 가장 작은 값을 찾아 맨 앞의 데이터와 교체
		// - 선택정렬 2회차 : 1~2에서 가장 작은 값을 찾아 맨 앞의 데이터와 교체
		// - 선택정렬 3회차 : 2~3에서 가장 작은 값을 찾아 맨 앞의 데이터와 교체
		// - 선택정렬 4회차 : 3~4에서 가장 작은 값을 찾아 맨 앞의 데이터와 교체
	
		int index = 0;
		
		for(int i = 0; i<data.length; i++) {
			for(int k=0; k<data.length-1; k++) {
				if(k+1 < data.length && data[k] > data[k+1]) {
					data[k] = data[k] + data[k+1];
					data[k+1] = data[k] - data[k + 1];
					data[k] = data[k] - data[k + 1];
				}
				
			}
			
			}	
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
		}
		
	}


