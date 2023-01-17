package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test04_1 {

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
		
//		for(int i=0; i<6; i++) {
		for(int i=0; i<list.size(); i++) {
		System.out.println(list.get(i));	
		
		}

	}

}
