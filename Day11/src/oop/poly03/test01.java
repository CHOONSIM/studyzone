package oop.poly03;

public class test01 {
	public static void main(String[] args) {
		
	Hwang a = new Hwang(); //정적
	 a.drink();
	 a.game();
	 a.teach();
	 
	 //출근
	 Teacher b = a; //Hwang -> Teacher (업캐스팅)
//	b.drink();  //없는건 아닌데 못씀
//	b.game():   //없는건 아닌데 못씀
	 b.teach();
	 
	 //퇴근
	 //Hwang c = b;
	 Hwang c = (Hwang)b; // Teacher -> Hwang (다운캐스팅) , double a = (double)b + c
	 c.drink();
	 c.game();
	 c.teach();
	 
	 //타입검사
	 System.out.println(b instanceof Hwang);
	}
	
}
