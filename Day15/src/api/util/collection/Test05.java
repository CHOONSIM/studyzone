package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test05 {

	public static void main(String[] args) {


//		Collection을 도와주는 Collections 클래스
		
		
//		List<?> list = new ArrayList<>();		모른다 = Object
		List<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		Collections.reverse(list);			//뒤집기
		System.out.println(list);
		
		Collections.shuffle(list);			//섞기
		System.out.println(list);
		
		Collections.sort(list);				//정렬
//		list.sort(null);;
//		Collections.sort(null, null);		//comparator 비교
//		Collections.sort(list, (a,b)->b-a);	//Lamda
		System.out.println(list);

	}

}
