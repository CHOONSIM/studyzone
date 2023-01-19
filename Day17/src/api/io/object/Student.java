package api.io.object;

import java.io.Serializable;

//내가 만든 클래스의 객체도 파일 출력이 되는가?
//- 입출력의 가능성이 있다면 자격을 부여(마킹)해야 한다.
//- java.io.Serializable 인터페이스를 상속
//- 상속받으면 경고가 나옴 → 
//				클래스의 버전을 관리할 것을 요구(serialVersionUID를 생성하여 숫자로 관리)
//- 만들지 않으면 클래스의 내용이 바뀔 때마다 무조건 serialVersionUID가 바뀌(통제안됨)
//- 입출력에서 제외하고 싶은 필드가 있다면 transient 키워드를 붙이면 된다.


public class Student implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String name;
	private /*transient*/ int score;
	
	
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
	public String toString() {
		return "student [name=" + name + ", score=" + score + "]";
	}

}
