package oop.poly;

public class Test01 {
	public static void main(String[] args) {
		
		//정적타입
		Pororo p = new Pororo();
		p.hello();
		Crong c = new Crong();
		c.hello();
		
		Toy t1 = new Pororo();
		t1.hello();
		Toy t2 = new Crong();
		t1.hello();
	}

}
