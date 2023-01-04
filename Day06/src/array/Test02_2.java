package array;

public class Test02_2 {
public static void main(String[] args) {
		
		//배열 생성
		int[] data = new int[] {10,20,30,40,50};// <-------data.length------>
     //int배열 data ------> [?][?][?][?][?] -----> new 때문에 [0][0][0][0][0]
		//                 ^기준에서 -----얼마나 떨어져있는지(자,ruler와 같음), 순서X 위치O
		
       System.out.println(data.length);
		
		
		//System.out.println(data); //리모컨 출력 (의미없음)
		
//		for(int i=0; i<=4; i++) {
//			System.out.println(data[i]); //시작점+0칸
//		}
       
       
		for(int i=0; i<=data.length-1; i++) {
			System.out.println(data[i]); //시작점+0칸
		}
		
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]); //시작점+0칸
		}
		
		
		int total = 0;
//		for(int i=0; i<=4; i++) {
//			total += data[i];
//		}
		
	
		
		
		for(int i=0; i<=data.length-1; i++) {
			total += data[i];
		}
		
		for(int i=0; i<data.length; i++) {
			total += data[i];
		}
//		for(int i=0; i<5; i++) {
//			total += data[i];
//		}
//		
		
		System.out.println(total);
		
	}

}
