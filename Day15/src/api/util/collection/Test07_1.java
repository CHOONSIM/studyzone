
package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test07_1 {

	public static void main(String[] args) {
		
//		리스트 2개에 데이터를 3개씩 넣어두고 연결하여 출력
		List<String> names = new ArrayList<>();
		
		names.add("피카츄");
		names.add("라이츄");
		names.add("파이리");
		
		List<String> items = new ArrayList<>();
		
		items.add("저녁사기");
		items.add("술사기");
		items.add("얻어먹기");
		
//		항목 섞기
		Collections.shuffle(items);
		
//		출력
		for(int i=0; i < 3; i++) {
			String name = names.get(i);
			String item = items.get(i);
			System.out.println(name + " --> " + item);
		}
		
//		System.out.println(names);
//		System.out.println(items);

	}

}

