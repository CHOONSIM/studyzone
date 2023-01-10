package oop.keyword04;

public class Test01 {
	public static void main(String[] args) {
		
		//static 필드/메소드는 객체없이 호출할 수 있다.
		System.out.println(GalaxyFold4.getCompany()); //올바른 접근방법
		
		GalaxyFold4 g1 = new GalaxyFold4("010-1234-5678", "블랙");
		System.out.println(g1.getCompany());  //잘못된 접근방법
		
		g1.setCompany("Apple"); //잘못된 접근방법
		GalaxyFold4.setCompany("화웨이"); //
	}

}
