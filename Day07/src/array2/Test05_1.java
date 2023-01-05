package array2;

public class Test05_1 {
	public static void main(String[] args) {
		
		//30, 50, 20, 10, 40 을 배열에 저장한 뒤
		//모든 데이터의 순서를 거꾸로 뒤집어서 재배치하고 출력
		//최초 30, 50, 20, 10, 40
		//변경 40, 10, 20, 50, 30
		
		//데이터의 개수 상관없이
		
//		데이터 개수   교체횟수(반복횟수)  교체위치 (인덱스위치) 
//		    n             n/2       [0] <--> [n-1]
//			
		//규칙
		//1. 교체횟수(반복횟수)는 데이터개수 / 2 이다
		//2. 0번과 마지막(length-1) 부터 교체를 시작한다.
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
	    for(int i=0; i<data.length/2; i++) {
	    	int k = data.length-1-i;
	    	System.out.println("i = "+ i + ", k =" + k);
	    
	    	//[i] <-->[k]
	    	int backup = data[i];
	    	data[i] = data[k];
	    	data[k] = backup;
	    }
	    for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}

}
