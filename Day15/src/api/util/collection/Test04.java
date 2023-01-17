package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test04 {

	public static void main(String[] args) {
		
//		List의 index 접근
		
		List<Integer> list = new ArrayList<>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
		list.add(3,600);	//중간 삽입
		
//		System.out.println(list);
		
		System.out.println(list.get(0));	//0번에 있는 것 꺼내기
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.get(5));
		

	}

}
