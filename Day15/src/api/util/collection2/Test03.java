package api.util.collection2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Set<Integer> memory = new TreeSet<>();
		memory.add(10);
		memory.add(12);
		
		System.out.println("글번호를 입력 하세요 : ");
		int no = sc.nextInt();
		
		
		if(memory.contains(no)) { //no가 memory에 있으면
			memory.remove(no);
			System.out.println(no + "번 글에 좋아요를 취소했습니다.");
		}
		else {
			memory.add(no);
			System.out.println(no + "번 글에 좋아요를 눌렀습니다.");
		}

		sc.close();
		


	}

}
