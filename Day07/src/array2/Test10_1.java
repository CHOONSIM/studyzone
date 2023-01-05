package array2;

public class Test10_1 {
	public static void main(String[]args) {
	    
		//버블정렬
		
		//데이터 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//처리
        //모든 데이터를 처리할 수 있도록 숫자를 길이와 연동
		
		for(int k=data.length-1; k>0; k--) {
			for(int i=0; i<k; i++) {
				//System.out.println("i = " + i + ", i+1 = "+ (1+i));
				if(data[i] > data[i+1]) { //앞 데이터가 더크면
					//앞과 뒤를 교체
					int backup = data[i];
					data[i] = data[i+1];
					data[i+1] = backup;
				}
			}	
		}
		
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
		}
		
	}


