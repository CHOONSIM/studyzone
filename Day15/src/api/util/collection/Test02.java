package api.util.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test02 {

	public static void main(String[] args) {
		
//		List 생성
//		List<형태> a = new ArrayList<형태>();
//		(주의)형태는 무조건 class여야 한다. 원시형은 wrapper 클래스로 대체하여 설정 
		
		List<String> a = new ArrayList<String>();
		List<String> b = new LinkedList<String>();
		
//		데이터 추가
		a.add("마리오");
		a.add("루이지");
		a.add("쿠파");
		
		System.out.println(a);
		
		b.add("마리오");
		b.add("루이지");
		b.add("쿠파");
		
		System.out.println(b);
		
//		포함 검사
		System.out.println(a.contains("피카츄"));
		System.out.println(a.contains("루이지"));
		
//		갯수 검사
		System.out.println(a.size());
		
//		위치 검사
		System.out.println(a.indexOf("피카츄"));
		System.out.println(a.indexOf("루이지"));
		
//		삭제
		a.remove("마리오");		//마리오 데이터와 일치하는 항목을 삭제(나머지가 앞으로 이동)
		b.remove(0);			//0번 index에 존재하는 항목을 삭제(나머지가 앞으로 이동)
		
		System.out.println(a);
		System.out.println(b);
	}

}
