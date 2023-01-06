package oop.test3;

public class Test01 {
	public static void main(String[] args) {
		
		
		Pocketmon p1 = new Pocketmon();
		Pocketmon p2 = new Pocketmon();
		Pocketmon p3 = new Pocketmon();
		Pocketmon p4 = new Pocketmon();
		
		
		p1.no = 1;
		p1.name = "이상해씨";
		p1.att = "풀,독";
		
		p2.no = 4;
		p2.name = "파이리";
		p2.att = "불꽃";

		p3.no = 7;
		p3.name = "꼬부기";
		p3.att = "물";

		p4.no = 25;
		p4.name = "피카츄";
		p4.att = "전기";

		
		System.out.print(p1.no);
		System.out.print("\t");
		System.out.print(p1.name);
		System.out.print("\t");
		System.out.print(p1.att);
		System.out.println();
		
		
		System.out.print(p2.no);
		System.out.print("\t");
		System.out.print(p2.name);
		System.out.print("\t");
		System.out.print(p2.att);
		System.out.println();
		
		System.out.print(p3.no);
		System.out.print("\t");
		System.out.print(p3.name);
		System.out.print("\t");
		System.out.print(p3.att);
		System.out.println();
		
		System.out.print(p4.no);
		System.out.print("\t");
		System.out.print(p4.name);
		System.out.print("\t");
		System.out.print(p4.att);
		
	}

}
