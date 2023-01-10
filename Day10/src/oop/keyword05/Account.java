package oop.keyword05;

public class Account {
	
	private String name;
	private static double rate = 1.2;
	static {
		//static 항목에 대한 초기화 코드를 작성할 수 있는 전용공간
		//ex : 1부터 100까지 더한 결과물 설정
		// - if, for등 각종 프로그래민 구문 사용 가능
		rate = 1.2;
	}
	private double pRate;
	private long balance;
	
	public Account(String name, double pRate, long balance) {
		this.setName(name);
		this.setpRate(pRate);
		this.setBalance(balance);
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public static void setRate(double rate) {
		if(rate < 0)return;
		Account.rate = rate;
	}
	public void setpRate(double pRate) {
		if(pRate < 0)return;
		this.pRate = pRate;
	}
	public void setBalance(long balance) {
		if(balance < 0) return;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public static double getRate() {
		return rate;
	}
	public double getpRate() {
		return pRate;
	}
	public long getBalance() {
		return balance;
	}
	

	public void output(){
		System.out.println("<내집마련 장기적금>");
		System.out.println("이름 : " + getName());
		System.out.println("기본이율 : " + getRate());
		//  or  System.out.println("기본이율 : " + Account.getRate());    (주의)this.getRate X
		System.out.println("우대이류 : " + getpRate());
		System.out.println("잔액 : " + getBalance());
		System.out.println();
	}
}
