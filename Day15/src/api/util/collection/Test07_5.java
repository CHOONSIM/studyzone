package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test07_5 {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in);) {
		
		System.out.print("인원 수 : ");
		int people = sc.nextInt();				//쓰레기 받이	(next -> nextInt)
		if(people < 2 || people > 24)
			throw new Exception("인원 수는 2명 이상 24명 이하로 입력하세요");
		sc.nextLine();
		
//		리스트 2개에 데이터를 3개씩 넣어두고 연결하여 출력
		List<String> names = new ArrayList<>();
		
		System.out.println("이름 입력");
		for(int i=0; i < people; i++) {
			names.add(sc.nextLine());
		}

		List<String> items = new ArrayList<>();
		
		System.out.println("항목 입력");
		for(int i=0; i < people; i++) {
			items.add(sc.nextLine());
		}
		
		
		sc.close();
		
//		항목 섞기
		Collections.shuffle(items);
		
//		출력
		for(int i=0; i < 3; i++) {
			String name = names.get(i);
			String item = items.get(i);
			System.out.println(name + " --> " + item);
		}

	}
	catch(Exception e){
		System.out.println("인원 수는 2명 이상 24명 이하로 입력하세요");
//		e.printStackTrace();
		
		}
	}

}