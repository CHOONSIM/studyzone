package oop.modifier02;

public class Test01 {
	public static void main(String[] args) {
		
		ExamScore e1 = new ExamScore("피카츄", 100, 90, 80);
		ExamScore e2 = new ExamScore("라이츄", 95, 92, 93);
		ExamScore e3 = new ExamScore("파이리", 70, 95, 95);
		
		e1.output();
		e2.output();
		e3.output();
	}

}
