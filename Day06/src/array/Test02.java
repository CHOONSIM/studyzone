package array;

public class Test02 {

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
		System.out.println(data[0]); //시작점+0칸
		System.out.println(data[1]); //시작점+1칸
		System.out.println(data[2]); //시작점+2칸
		System.out.println(data[3]); //시작점+3칸
		System.out.println(data[4]); //시작점+4칸
		
		int total = data[0] + data[1] + data[2] + data[3] + data[4];
		System.out.println(total);
		
	}

}
