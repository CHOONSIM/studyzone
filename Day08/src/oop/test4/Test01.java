package oop.test4;

public class Test01 {
	public static void main(String[] args) {
		
		//선수 객체 생성
		
		Olympic o1 = new Olympic();
		Olympic o2 = new Olympic();
		Olympic o3 = new Olympic();
		
		//데이터 초기화
		o1.name = "진종오";
		o1.event = "사격";
		o1.season = "하계";
		o1.gold = 4;
		o1.silver = 2;
		o1.bronze = 0;
		
		o2.name = "김수녕";
		o2.event = "양궁";
		o2.season = "하계";
		o2.gold = 4;
		o2.silver = 1;
		o2.bronze = 1;

		o3.name = "전이경";
		o3.event = "쇼트트랙";
		o3.season = "동계";
		o3.gold = 4;
		o3.silver = 0;
		o3.bronze = 1;
		
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
		
		System.out.print(o1.name);
		System.out.print("\t");
		System.out.print(o1.event);
		System.out.print("\t");
		System.out.print(o1.season);
		System.out.print("\t");
		System.out.print(o1.gold);
		System.out.print("\t");
		System.out.print(o1.silver);
		System.out.print("\t");
		System.out.print(o1.bronze);
		
		System.out.println();
		
		System.out.print(o2.name);
		System.out.print("\t");
		System.out.print(o2.event);
		System.out.print("\t");
		System.out.print(o2.season);
		System.out.print("\t");
		System.out.print(o2.gold);
		System.out.print("\t");
		System.out.print(o2.silver);
		System.out.print("\t");
		System.out.print(o2.bronze);
		
		System.out.println();
		
		System.out.print(o3.name);
		System.out.print("\t");
		System.out.print(o3.event);
		System.out.print("\t");
		System.out.print(o3.season);
		System.out.print("\t");
		System.out.print(o3.gold);
		System.out.print("\t");
		System.out.print(o3.silver);
		System.out.print("\t");
		System.out.print(o3.bronze);
		
		
		
	}

}
