package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test01 {

	public static void main(String[] args) {
		
//		ex : 전화번호부 vs 통화내역
//		배열 길이지정 필요하지만 자동으로 늘어남
//		전화번호부는 데이터가 저장될 때 오름차순 정렬처리가 이루어진다.(순서무시)
//		방명록은 작성 순서대로 저장된다.(순서보장)
//		순서가 보장되는 저장소를 List라 부르고, 무시되는 저장소를 Set이라고 부름
		
//		TreeSet a = new TreeSet();			//전화번호부
//		ArrayList b = new ArrayList();		//방명록
		
//		Set a = new TreeSet();				//업캐스팅
//		Set b = new ArrayList();
		
		Set<String> a = new TreeSet<String>();
		List<String> b = new ArrayList<String>();
		
		a.add("피카츄");		b.add("피카츄");
		a.add("라이츄");		b.add("라이츄");
		a.add("파이리");		b.add("파이리");
		a.add("꼬부기");		b.add("꼬부기");
		
		System.out.println(a.size());		//a의 데이터 개수
		System.out.println(b.size());
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);

	}

}
