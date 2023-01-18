package api.util.collection4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03_1 {

	public static void main(String[] args) {
		
		Map<String, Integer> db = new HashMap<>();
		db.put("자바", 5);
		db.put("파이썬", 10);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("검색어 : ");
			String keyword = sc.nextLine();
			
			//- 검색어가 존재할 때는 검색횟수를 꺼내어 +1 한 뒤 다시 저장
			//- 검색어가 존재하지 않을 때는 검색횟수는 1로 설정하여 새로 저장
			if(db.containsKey(keyword)) {//검색어가 db에 존재한다면
				int count = db.get(keyword);
				count += 1;
				db.put(keyword, count);
				System.out.println("["+keyword+"] 검색 완료. ["+count+"회 검색됨]");
			}
			else {//검색어가 db에 존재하지 않는다면
				db.put(keyword, 1);
				System.out.println("["+keyword+"] 검색 완료. [1회 검색됨]");
			}
		}
		
//		sc.close();

	}

}
