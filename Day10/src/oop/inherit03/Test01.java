package oop.inherit03; 

public class Test01 {
	public static void main(String[] args) {
		
		Chrome a = new Chrome();
		
		a.name();
		a.url();
		a.refresh();
		a.move();
		a.develop();
		a.chromeStore();
		
		
		Edge b = new Edge();
		b.name();
		b.url();
		b.refresh();
		b.move();
		b.fullScreen();
		
		Whale c = new Whale();
		c.name();
		c.url();
		c.refresh();
		c.move();
		c.papago();
		c.naverSearch();
	}

}
