package jdbc.select;

//	pocketmon 테이블의 1줄을 옮겨 닮기 위한 클래스
//	- DB와 같은 이름의 필드를 만들고 기본생성자, getter/setter 메소드까지 구현
//	- DTO는 테이블당 1개 구현

public class PocketmonDto {
	private int no;
	private String name;
	private String type;
	public PocketmonDto() {
		super();
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
