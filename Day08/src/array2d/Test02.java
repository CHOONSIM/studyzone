package array2d;

public class Test02 {
	public static void main(String[] args) {
		
		//2차원 배열
		// - 표의 형태를 가진 데이터 저장소
		//  -> 1차원 배열이 모인 형태
		
		int[] a = new int[] {10, 20, 30};
		int[] b = new int[] {40, 50, 60};
		
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i]);
			System.out.print("\t");
		}
		System.out.println();
		
		for(int i=0; i < b.length; i++) {
			System.out.print(b[i]);
			System.out.print("\t");
		}
		System.out.println();
	}

}
