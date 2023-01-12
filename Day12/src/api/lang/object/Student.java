package api.lang.object;

import java.util.Objects;

public class Student  /*extends Object*/{
	private String name;
	private int score;
	
	//생성자
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name);
	}
	
	

}
