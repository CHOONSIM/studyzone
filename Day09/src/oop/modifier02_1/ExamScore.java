package oop.modifier02_1;

public class ExamScore {
	
	//field
	private String name;
	private int korean;
	private int english;
	private int math;
	
	//setter
	void setName(String name) {
		this.name = name;
	}
	void setKorean(int korean) {
		if(korean >= 0 && korean <= 100) {
			this.korean = korean;	
//		if(korean < 0 || korean > 100) {   조건이 많을 경우 (많이 그만둬야할 때)
//			return;//그만하시요
//		}
		}
	}
	void setEnglish(int english) {
		if(english >= 0 && english <= 100) {
			this.english = english;			
		}	
	}
	void setMath(int math) {
		if(math >= 0 && math <= 100) {
			this.math = math;			
		}
	}
	

	
	//getter
	String getName() {
		return this.name;
	}
	int getKorean() {
		return this.korean;
	}
	int getEnglish() {
		return this.english;
	}
	int getMath() {
		return this.math;
	}
	
	//가상의 getter 메소드를 만들어 개발을 편하게 한다.
	// -> total 이라는 필드는 없지만 total을 계산해서 반환하는 getTotal()을 만든다.
	int getTotal() {
		//return this.total;
		return this.getKorean() + this.getEnglish() + this.getMath();
	}
	
	double getAverage() {
		return this.getTotal() / 3.0;
	}
	
	
	
	//생성자
	ExamScore(String name, int korean, int english, int math){
		this.setName(name);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	//계산항목들은 필드를 만들지 않고 그때그때 계산
	
	void output() {
		System.out.println("<학생 성적 정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("국어 : " + this.getKorean());
		System.out.println("영어 : " + this.getEnglish());
		System.out.println("수학 : " + this.getMath());
		//int total = this.korean + this.english + this.math;
		System.out.println("총점 : " + this.getTotal() + "점");
		//double average = total / 3.0;
		System.out.println("평균 : " + this.getAverage() + "점");
		System.out.println();
	}
	

}
