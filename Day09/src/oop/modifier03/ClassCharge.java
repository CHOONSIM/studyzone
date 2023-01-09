package oop.modifier03;

public class ClassCharge {
	
	//field
	private String name;
	private int time;
	private int charge;
	private String type;
	
	//setter
	void setName(String name) {
		this.name = name;
	}
	void setTime(int time) {
		if(time % 30 != 0) { //30시간 단위가 아닐 경우(30의 배수면)
			return;
		}
		if(time < 0) {
			return;
		}
		this.time = time;			
	}
	void setCharge(int charge) {
		if(charge < 0) {
			return;
		}
		this.charge = charge;			
	}
	void setType(String type) {
		switch(type) {
		case "온라인","오프라인","혼합":
		    this.type = type;
		}
	}
	
	//getter
	String getName() {
		return this.name;
	}
	int getTime() {
		return this.time;
	}
	int getCharge() {
		return this.charge;
	}
	String getType() {
		return this.type;
	}

	
	//생성자
	ClassCharge (String name, int time, int charge, String type){
		this.setName(name);
		this.setTime(time);
		this.setCharge(charge);
		this.setType(type);
	}
	
	void output() {
		 System.out.println("<과정 정보>");
		 System.out.println("강좌명 : " + this.getName());
		 System.out.println("강의시간 : " + this.getTime());
		 System.out.println("수강료 : " + this.getCharge());
		 System.out.println("구분 : " + this.getType());
         System.out.println();
		
	}

}
