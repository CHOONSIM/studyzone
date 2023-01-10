package oop.inherit03;

//상위 클래스 , 슈퍼 클래스, 부모 클래스
public class Browser {
	
	//공통 필드
	private String url;
	private String refresh;
	private String move;
	
	
	public void setUrl(String url) {
		this.url = url;
	}
	public void setRefresf(String refresh) {
		this.refresh = refresh;
	}
	public void setMove(String move) {
		this.move = move;
	}
	public String getUrl() {
		return url;
	}
	public String getRefresh() {
		return refresh;
	}
	public String getMove() {
		return move;
	}
	
	//공통 메소드
	public void url() {
		System.out.println("주소저장");
	}
	public void refresh() {
		System.out.println("새로고침");
	}
	public void move() {
		System.out.println("페이지 이동");
	}

}
