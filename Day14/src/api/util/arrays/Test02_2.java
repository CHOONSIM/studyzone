package api.util.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test02_2 {

	public static void main(String[] args) {
		
//		배열 정렬
//		- Arrays는 원시형과 문자열은 오름차순 정렬이 가능
//		- 다른 방식이나 객체일 경우는 정렬 기준을 따로 구현해야 한다.
//		- java.util.Comparator를 사용하여 정렬 기준을 생성
//		- comparator<T> = 비교도구<비교대상>
//		- FuntionalInterFace -> 함수형 추론식-> Lambda
		
		Integer[] data = new Integer[] {30, 50, 20, 10, 40};
			
					
		Arrays.sort(data, (o1,o2) -> o2-o1);		//오름차순		
		
		System.out.println(Arrays.toString(data));

	}

}
