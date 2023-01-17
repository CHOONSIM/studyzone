package api.util.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test04 {

	public static void main(String[] args) {
		
//		데이터 준비
		Set<String> galaxy = Set.of("통화", "문자", "게임", "영상통화", "삼성페이");
		Set<String> iphone = Set.of("통화", "문자", "게임", "아이튠즈", "시리");
		
//		합집합 - 두 휴대폰이 가진 모든 기능 -> galaxy U iphone -> union
		Set<String> union = new TreeSet<>();
		union.addAll(galaxy);
		union.addAll(iphone);
		
		System.out.println(union);
		
//		교집합 - 두 휴대폰이 가진 공통 기능 -> galaxy n iphone -> intersection
		Set<String> intersect = new TreeSet<>(galaxy);
		intersect.retainAll(iphone);		//retainAll = 겹치는것만 남고 제거
		System.out.println(intersect);
		
//		차집합 - 어느 한 쪽 휴대폰만 가진 기능
//		galaxy - iphone 또는 iphone - galaxy
		Set<String> minus = new TreeSet<>(galaxy);
		minus.removeAll(iphone);			//removeAll = ()에 있는것 삭제 = galaxy - iphone
		System.out.println(minus);
	}

}
