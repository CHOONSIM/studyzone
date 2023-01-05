package array2;

public class Test10_2 {
	public static void main(String[]args) {
	    
		//버블정렬
		
		//데이터 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//처리
		//1회차 정렬
//		[0]  [1]
//		[1]  [2]
//		[2]  [3]
//		[3]  [4]
		
		for(int i=0; i<=3; i++) {
			//System.out.println("i = " + i + ", i+1 = "+ (1+i));
			if(data[i] > data[i+1]) { //앞 데이터가 더크면
				//앞과 뒤를 교체
				int backup = data[i];
				data[i] = data[i+1];
				data[i+1] = backup;
			}
		}
		
		
		
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
		}
		
	}


