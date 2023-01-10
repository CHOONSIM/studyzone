package oop.inner01;

public class Thief {
	private String name;  //도둑은 이름을 가질 수 있다.
	private Gun gun;      //도둑은 권총을 가질 수 있다?
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gun getGun() {
		return gun;
	}
	public void setGun(Gun gun) {
		this.gun = gun;
	}

}
