package api.util.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test05 {

	public static void main(String[] args) {
		
		Set<String> chul = Set.of("아바타:물의 길", "더 퍼스트 슬램덩크", "영웅");
		Set<String> yung = Set.of("영웅","올빼미", "스위치", "신비아파트");
			
		//둘 다
		Set<String> intersect = new TreeSet(chul);
		intersect.retainAll(yung);
		
		System.out.println("둘 다 본 영화 목록 : " + intersect);
		
//		풀이
		
		Set<String> union = new TreeSet<>();
		union.addAll(chul);
		union.addAll(yung);
		
		Set<String> chulOnly = new TreeSet<>(chul);
		chulOnly.removeAll(yung);
		Set<String> yungOnly = new TreeSet<>(yung);
		yungOnly.removeAll(chul);
		Set<String> answer = new TreeSet<>(chulOnly);
		answer.addAll(yungOnly);
		System.out.println(answer);
		
		
//		내 풀이
		
		Set<String> minus = new TreeSet<>(chul);
		minus.removeAll(yung);
		System.out.println("철수만 본 영화 목록 : " + minus);
		
		Set<String> minus1 = new TreeSet<>(yung);
		minus1.removeAll(chul);
		System.out.println("영희만 본 영화 목록 : " + minus1);
		
		
	}

}
