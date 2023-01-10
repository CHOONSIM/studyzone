package oop.modifier07;

public class Student {
	
	private String name;
	private int grade;
	private int korean;
	private int english;
	private int math;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setKorean(int korean) {
		if(korean < 0 || korean > 100) return;
		this.korean = korean;
	}
	public void setEnglish(int english) {
		if(english < 0 || english > 100) return;
		this.english = english;
	}
	public void setMath(int math) {
		if(math < 0 || math > 100) return;
		this.math = math;
	}
	
	
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public int getKorean() {
		return korean;
	}
	public int getEnglish() {
		return english;
	}
	public int getMath() {
		return math;
	}
	
	//가상의 getter
	
	public int getTotal() {  
		return this.getKorean() + this.getEnglish() + this.getMath(); //this.get 생략 가능
	}
	public double getAverage() {
		return this.getTotal() / 3.0;
	}
	public String getRank() {
		if(this.getAverage() >= 90) return "A";
		else if(this.getAverage() >= 80) return "B";
		else if(this.getAverage() >= 70) return "C";
		else return "F";
	}
//	public String getRank() {               //작업효율 올리는 팁
//		double avg = getAverage();
//		if(avg >= 90) return "A";
//		else if(avg >= 80) return "B";
//		else if(avg >= 70) return "C";
//		else return "F";
//	}
	
	
	public Student(String name, int grade, int korean, int english, int math)
	{
		this.setName(name);
		this.setGrade(grade);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	
	public void output() {
		System.out.println("<학생 성적 정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("학년 : " + this.getGrade() + "학년");
		System.out.println("국어 : " + this.getKorean() + "점");
		System.out.println("영어 : " + this.getEnglish() + "점");
		System.out.println("수학 : " + this.getMath() + "점");
		System.out.println("총점 : " + this.getTotal() + "점");
		System.out.println("평균 : " + this.getAverage() + "점");
		System.out.println("등급 : " + this.getRank() + "등급");
		System.out.println();
	}
	
	

}