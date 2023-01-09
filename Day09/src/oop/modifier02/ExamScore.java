package oop.modifier02;

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
	
	int total = korean + english + math;
	double average = (double)total / 3.0;
	
	
	//생성자
	ExamScore(String name, int korean, int english, int math){
		this.setName(name);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	void output() {
		System.out.println("<학생 성적 정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("국어 : " + this.getKorean());
		System.out.println("영어 : " + this.getEnglish());
		System.out.println("수학 : " + this.getMath());
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + average);
		System.out.println();
	}
	

}
