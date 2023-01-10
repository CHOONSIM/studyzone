package oop.modifier06;

public class Class {
	
	private String name;
	private String className;
	private int score;
	private int check;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setScore(int score) {
		if(score < 0 || score > 100) return;
			this.score = score;			
	}
	public void setCheck(int check) {
		if(check < 0 || check > 100) return;
		this.check = check;
	}
	public String getName() {
		return name;
	}
	public String getClassName() {
		return className;
	}
	public int getScore() {
		return score;
	}
	public int getCheck() {
		return check;
	}
	
	
	//가상의 getter
	public int getTotal() {
		return this.getScore() + this.getCheck();
	}
	public double getAverage() {
		return this.getTotal() / 2.0;
	}
	public boolean getPass() {
		return getScore() >= 40 && getCheck() >=40 && getAverage() >=60;
	}
	
	
	//생성자
	Class(String name, String className, int score, int check){
		this.setName(name);
		this.setClassName(className);
		this.setScore(score);
		this.setCheck(check);
	}
	
	void output() {
		System.out.println("이름 :" + this.getName());
		System.out.println("과목 :" + this.getClassName());
		System.out.println("서술형점수 :" + this.getScore() + "점");
		System.out.println("평가자체크리스트점수 :" + this.getCheck()+ "점");
		System.out.println("총점 :" + this.getTotal()+ "점");
		System.out.println("평균 :" + this.getAverage()+ "점");
		if(this.getPass()) {
			System.out.println("처리결과 : 통과");
		}
		else {
			System.out.println("처리결과 : 재평가");
		}
		System.out.println();
	}
	

}
