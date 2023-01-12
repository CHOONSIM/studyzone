package oop.multi02;

public class Test01 {
	
	public static void main(String[] args) {
		
		
		Airplane a = new Airplane();
		a.move();
		a.fly();
		a.reservation();
		System.out.println();
		
		Bus b = new Bus();
		b.move();
		System.out.println();
		
		Drone d = new Drone();
		d.on();
		d.off();
		d.move();
		d.fly();
		System.out.println();
		
		Kickboard k = new Kickboard();
		k.on();
		k.off();
		k.move();
		System.out.println();
		
		Train t = new Train();
		t.move();
		t.reservation();
		
		
		//자료형으로 검사
		test(d);
		test(a);
//		test(t);
//		test(b);
//		test(k);
		
		test2(d);
//		test2(a);
//		test2(t);
//		test2(b);
		test2(k);
		
		
	}
	
	// 이 메소드는 Flyable을 상속받은 클래스만 사용이 가능
	public static void test(Flyable flyable) {}
	
	// 이 메소드는 Electronic을 상속받은 클래스만 사용이 가능
	public static void test2(Electronic electronic) {}
	

}