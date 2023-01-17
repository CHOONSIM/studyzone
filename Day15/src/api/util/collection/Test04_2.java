package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test04_2 {

	public static void main(String[] args) {
		
//		List의 index 접근
		
		List<Integer> list = new ArrayList<>();
		list.add(100);			//int(원시형) ----> Integer(참조형) (자동포장, auto-boxing)
		list.add(200);			
		list.add(300);			//null은 참조형에서만 존재, null이 있다면 Integer사용
		list.add(400);
		list.add(500);
		list.add(3,600);		//중간 삽입
		
//		foreach 구문(확장 for)
//		- 어차피 전체를 처리할 생각이라면 인덱스를 생략하고 추출한 값을 담을 변수만 정의
//		- Iterable을 상속받은 클래스라면 모두 사용 가능한 구문
//		- 전체만 가능하다는 담점이 존재
		
		for(int n : list) {		//Integer ----> int (자동포장해제, auto-unboxing)
			System.out.println(n);
		}
		

	}

}
