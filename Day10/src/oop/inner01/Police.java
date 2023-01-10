package oop.inner01;

public class Police {
	private String name;  //경찰은 이름을 가진다
	private Gun gun;      //경찰은 권총을 가진다.
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	public Gun getGun() {
		return gun;
	}

}
