package oop.modifier04;

     //class Car { //다른 패키지에서는 사용 불가
public class Car { //다른 패키지에서도 사용 가능
	private String name;
	private int price;
	
	   
	//setter & getter 메소드는 일반적으로 public으로 만든다
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
	//생성자도 일반적으로 public으로 구현한다
	public Car(String name, int price){
		this.setName(name);
		this.setPrice(price);
	}
	
	//출력
	public void output() {
		System.out.println(this.getName());
		System.out.println(this.getPrice());
	}


}
