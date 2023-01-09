package oop.method1;

public class CellphoneFee {
	
	String company, name;
	int monthfee, data, callmin, text;
	
	void setting (String company, String name, int monthfee, int data, int callmin, int text) {
		this.company = company;
		this.name = name;
		this.monthfee = monthfee;
		this.data = data;
		this.callmin = callmin;
		this.text = text;
	}
	
	void output () {
		System.out.println("<요금제 정보>");
		System.out.println("통신사 : "+ this.company);
		System.out.println("이름 : "+ this.name);
		System.out.println("월정액요금 : "+ this.monthfee);
		System.out.println("월 데이터 : "+ this.data);
		System.out.println("월 통화량 : "+ this.callmin);
		System.out.println("월 문자량 : "+ this.text);
		System.out.println();
		}

}
