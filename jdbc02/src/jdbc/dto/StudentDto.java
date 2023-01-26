package jdbc.dto;

public class StudentDto {
	private int no;
	private String name;
	private int korean;
	private int english;
	private int math;
	public StudentDto() {
		super();
		
	}
	@Override
	public String toString() {
		return "StudentDto [no=" + no + ", name=" + name + ", korean=" + korean + ", english=" + english + ", math="
				+ math + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
}
