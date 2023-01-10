package oop.modifier07;

public class Test01 {
	public static void main(String[] args) {
		
		Student s1 = new Student("마리오", 1, 90, 80, 70);
		Student s2 = new Student("루이지", 1, 85, 85, 83);
		Student s3 = new Student("쿠파", 1, 70, 60, 55);
		
		s1.output();
		s2.output();
		s3.output();
		
	}

}