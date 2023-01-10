package oop.keyword01;

public class Member {
	
	//필드에서 final을 사용하려고 할 때
	// - final 필드는 반드시 초기화가 되어야 한다.
	// - 생성자에 반드시 final 필드를 초기화하도록 코드를 구현해야 함
	private final String nickname;
	private String auth;
	
	//생성자 여러개 (오버로딩)
	
	public Member(String nickname) {
//		this.nickname = nickname;
//		this.auth = "준회원";
		this(nickname, "준회원"); //생성자 몰아주기
	}
	public Member(String nickname, String auth) {
		this.nickname = nickname;
		this.auth = auth;
	}
}

//(주의) final 필드는 setter 메소드를 가질 수 없다.
