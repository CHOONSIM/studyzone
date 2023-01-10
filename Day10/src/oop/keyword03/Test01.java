package oop.keyword03;

public class Test01 {
	public static void main(String[] args) {
		
		GalaxyFold4 g1 = new GalaxyFold4("01012345678", "블랙");
		GalaxyFold4 g2 = new GalaxyFold4("01098765432", "실버");
		GalaxyFold4 g3 = new GalaxyFold4("01022224444", "화이트");
		
		g1.setCompany("apple");
		
		g1.output();
		g2.output();
		g3.output();
		
	}

}
