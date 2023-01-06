package oop.test4;

public class Test01_1 {
	public static void main(String[] args) {
		
		//선수 객체 생성
		
		Olympic o1 = new Olympic();
		Olympic o2 = new Olympic();
		Olympic o3 = new Olympic();
		
		//데이터 초기화 setting
		o1.setting("진종오", "사격", "하계", 4, 2, 0);
		
		o2.setting("김수녕", "양궁", "하계", 4, 1, 1);

		o3.setting("전이경", "쇼트트랙", "동계", 4, 0, 1);
		
		//출력
		System.out.print("이름");
		System.out.print("\t");
		System.out.print("종목");
		System.out.print("\t");
		System.out.print("구분");
		System.out.print("\t");
		System.out.print("금메달");
		System.out.print("\t");
		System.out.print("은메달");
		System.out.print("\t");
		System.out.print("동메달");
		
		System.out.println();
		
		o1.output();           //o1을 주인공으로해서 output의 코드를 실행하라(this -> o1)
		
		System.out.println();
		
		o2.output();
		
		System.out.println();
		
	    o3.output();
		
		
		
	}

}
