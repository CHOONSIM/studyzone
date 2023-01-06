package oop.test4;

public class Olympic {
	
	//member field (멤버필드) - 데이터 저장
	
	String name, event, season;
	int gold, silver, bronze;
	
	//member method(멤버 메소드) - 코드 저장
	
	//기본형태 : void  이름(준비물)  {코드}
	
	// - this : 코드가 실행될 당시의 주인공(=자기 자긴 객체, 내꺼)
	
	void output() {
		System.out.print(this.name);
		System.out.print("\t");
		System.out.print(this.event);
		System.out.print("\t");
		System.out.print(this.season);
		System.out.print("\t");
		System.out.print(this.gold);
		System.out.print("\t");
		System.out.print(this.silver);
		System.out.print("\t");
		System.out.print(this.bronze);
	}
	
	void setting(String name, String event, String season, int gold, int silver, int bronze) {
		this.name = name;
		this.event = event;
		this.season = season;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	
	

}
