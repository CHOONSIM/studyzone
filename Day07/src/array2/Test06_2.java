package array2;

public class Test06_2 {
	public static void main(String[] args) {
		
		//30, 50, 20, 10, 40 을 배열에 저장한 뒤
		//모든 데이터를 시계방향으로 2번 이동한 결과물 출력
		//최초 ; 30 50 20 10 40
		//1회전 ; 40 30 50 20 10
		//2회전 ; 10 40 30 50 20
		
		
		//어려운
		//동일한 크기의 배열이 생겨 메모리 크지만 속도가 비교적 빠름
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//동일한 크기의 배열을 생성
		int[] copy = new int[data.length];
		
		for(int i=0; i < data.length; i++) {
			//int p =(i+2) % 5;  //나머지연산을 이용하여 보낼 수있음
			int p = (i + 2) % data.length;
			//System.out.println("i = " + i + ", p = "+p);
			copy[p] = data[i];
		}
		
	
		
		 for(int i=0; i<copy.length; i++) {
				System.out.print(copy[i]);
				System.out.print(" ");
			}
		
	}

}
