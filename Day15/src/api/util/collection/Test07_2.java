package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test07_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		리스트 2개에 데이터를 3개씩 넣어두고 연결하여 출력
		List<String> names = new ArrayList<>();
		
		System.out.println("이름 입력");
		names.add(sc.nextLine());
		names.add(sc.nextLine());
		names.add(sc.nextLine());
		
		List<String> items = new ArrayList<>();
		
		System.out.println("항목 입력");
		items.add(sc.nextLine());
		items.add(sc.nextLine());
		items.add(sc.nextLine());
		
		
		sc.close();
		
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