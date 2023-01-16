package api.util.arrays;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {
		
//		Arrays 클래스
//		- 배열에 대한 도우미
		
		int[] a = new int[] {30, 50, 20, 10, 40};
			System.out.println(Arrays.toString(a));		//1차원 배열에서 사용
//			System.out.println(a.toString());			//안씀 
			
//			int[] b = new int[]{30, 50, 20, 10, 40};
			int[] b = Arrays.copyOf(a, a.length);		//배열 복제
			System.out.println(a == b);					//레퍼런스는 당연히 다름
			System.out.println(a.equals(b));			//배열은 equals 재정의가 불가능
			System.out.println(Arrays.equals(a,b));		//내용을 비교
			
		int[] c = new int[10];
		Arrays.fill(c,10);
		System.out.println(Arrays.toString(c));
	}

}
