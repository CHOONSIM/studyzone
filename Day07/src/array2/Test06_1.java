package array2;

public class Test06_1 {
	public static void main(String[] args) {
		
		//30, 50, 20, 10, 40 을 배열에 저장한 뒤
		//모든 데이터를 시계방향으로 2번 이동한 결과물 출력
		//최초 ; 30 50 20 10 40
		//1회전 ; 40 30 50 20 10
		//2회전 ; 10 40 30 50 20
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		
		//5개일경우
//		int backup = data[4];
//		data[4] = data[3];
//		data[3] = data[2];
//		data[2] = data[1];
//		data[1] = data[0];
//		data[0] = backup;
		
		//두바퀴 회전
		for(int k=0; k<2; k++) {
		//데이터 다수 (한바퀴 회전)
		int backup = data[data.length-1]; //마지막 데이터(개수 -1)
		for(int i=data.length-1; i>0; i--) { //마지막부터 1까지
		    data[i] = data[i-1];
		}
		data[0] = backup;
		}
		
		 for(int i=0; i<data.length; i++) {
				System.out.print(data[i]);
				System.out.print(" ");
			}
		
	}

}
