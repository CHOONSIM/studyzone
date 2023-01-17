package api.util.collection2;

import java.util.HashSet;
import java.util.Set;

public class Test01 {

	public static void main(String[] args) {


//		set
//		- 정해진 방식에 의해 데이터를 저장하는 중복 없는 저장소
//		- 주 목적은 전체를 빠르게 조회하는 것
//		- 중복에 관련된 (중복을 배제하는)
//		- 위치 관련된 명령은 불가능(forEach 제외)
		
//		TreeSet<Integer> set = new TreeSet<>();
//		Set<Integer> set = new TreeSet<>();
		Set<Integer> set = new HashSet<>();
		
		set.add(5);
		set.add(3);
		set.add(8);
		set.add(1);
		set.add(4);
		set.add(9);
		set.add(7);
		
		System.out.println(set);
		System.out.println(set.size());
		
		System.out.println(set.contains(10));		//10이 있는지
		System.out.println(set.contains(7));		//7이 있는지
		
//		System.out.println(set.indexOf());			//indexOf() 없음
		
		set.remove(5);
		System.out.println(set);
		
//		get() 없음
		
//		forEach는 있음
		for(int n : set) {
			System.out.println(n);			
		}

	}

}
