package abstract01;

public class Test02 {
	public static void main(String[] args) {
		
		// 좌/우가 일치하도록 생성한 코드(정적 타입 생성 구분)
		Iphone13 a = new Iphone13("black");
		Iphone14 b = new Iphone14("silver");
		Galaxy22s c = new Galaxy22s("wine");
		GalaxyFold4 d = new GalaxyFold4("brown");
		
		
		// 좌/우가 일지하지 않도록 생성한 코드 (동적 타입 생성 구문)
		Mobile m1 = new Iphone13("black");
		Mobile m2 = new Iphone14("silver");
		Mobile m3 = new Galaxy22s("wine");
		Mobile m4 = new GalaxyFold4("brown");
		
		Iphone ip1 = new Iphone13("black");
		Iphone ip2 = new Iphone14("silver");
		Galaxy g1 = new Galaxy22s("wine");
		Galaxy g2 = new GalaxyFold4("brown");
	
		//ex ; 휴대폰을 10개 보관할 수 있는 배열
		Mobile[] arrr1 = new Mobile[10];
		
		//ex : 아이폰을 10개 보관할 수 있는 배열
		Iphone[] arr2 = new Iphone[10];
	}

}
