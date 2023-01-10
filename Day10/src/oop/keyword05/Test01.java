package oop.keyword05;

public class Test01 {
	public static void main(String[] args) {
		Account.setRate(1.2);
		System.out.println(Account.getRate());     //전체적으로 바뀜
		
		Account a1 = new Account("유재석", 0.3, 50000000);
		Account a2 = new Account("강호동", 0.5, 35000000);
		Account a3 = new Account("신동엽", 0.2, 80000000);
		
		a1.output();
		a2.output();
		a3.output();
		
	}
}
