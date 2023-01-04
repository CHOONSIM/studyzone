package array;

public class Test02_1 {
public static void main(String[] args) {
		
		//배열 생성
		int[] data = new int[5];
     //int배열 data ------> [?][?][?][?][?] -----> new 때문에 [0][0][0][0][0]
		//                 ^기준에서 -----얼마나 떨어져있는지(자,ruler와 같음), 순서X 위치O
		
      //data = 10;  //error(리모컨은 변경불가)
		
		data[0]=10;
		data[1]=20;
		data[2]=30;
		data[3]=40;
		data[4]=50;
		
		System.out.println(data); //리모컨 출력 (의미없음)
		
		for(int i=0; i<=4; i++) {
			System.out.println(data[i]); //시작점+0칸
		}
		
		int total = 0;
		for(int i=0; i<=4; i++) {
			total += data[i];
		}
		
		System.out.println(total);
		
	}

}
