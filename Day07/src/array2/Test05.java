package array2;

public class Test05 {
	public static void main(String[] args) {
		
		//30, 50, 20, 10, 40 을 배열에 저장한 뒤
		//모든 데이터의 순서를 거꾸로 뒤집어서 재배치하고 출력
		//최초 30, 50, 20, 10, 40
		//변경 40, 10, 20, 50, 30
		//데이터가 5개일때
		
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//재배치
		int backup = data[0];
		data[0] = data[4];
		data[4] = backup;

//      내풀이		
//		int backup2 = data[1];
//		data[1] = data[3];
//		data[3] = backup2;
//		
		backup = data[1];
		data[1] = data[3];
		data[3] = backup;
		
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}

}
