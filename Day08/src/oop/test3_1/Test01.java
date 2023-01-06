package oop.test3_1;

public class Test01 {
	public static void main(String[] args) {
		
		//int[][] data = new int[4][3];
		
		Pocketmon p1 = new Pocketmon();
		Pocketmon p2 = new Pocketmon();
		Pocketmon p3 = new Pocketmon();
		Pocketmon p4 = new Pocketmon();
		
		
		p1.no = 1;
		p1.name = "이상해씨";
		p1.att = new String[] {"풀","독"};
		
		p2.no = 4;
		p2.name = "파이리";
		p2.att = new String[] {"불꽃"};

		p3.no = 7;
		p3.name = "꼬부기";
		p3.att = new String[] {"물"};

		p4.no = 25;
		p4.name = "피카츄";
		p4.att = new String[] {"전기"};

		
		System.out.print(p1.no);
		System.out.print("\t");
		System.out.print(p1.name);
		System.out.print("\t");
		for(int i=0; i<p1.att.length; i++){
		System.out.print(p1.att[i]);
		}
		System.out.println();
		
		
		System.out.print(p2.no);
		System.out.print("\t");
		System.out.print(p2.name);
		System.out.print("\t");
		for(int i=0; i<p2.att.length; i++){
			System.out.print(p2.att[i]);
			}
		System.out.println();
		
		System.out.print(p3.no);
		System.out.print("\t");
		System.out.print(p3.name);
		System.out.print("\t");
		for(int i=0; i<p3.att.length; i++){
			System.out.print(p3.att[i]);
			}
		System.out.println();
		
		System.out.print(p4.no);
		System.out.print("\t");
		System.out.print(p4.name);
		System.out.print("\t");
		for(int i=0; i<p4.att.length; i++){
			System.out.print(p4.att[i]);
			}
		
	}

}
