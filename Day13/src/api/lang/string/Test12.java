package api.lang.string;

public class Test12 {
	public static void main(String[] args) {
		
		//목표 : 비밀번호 검사식 만들기
		// - 반드시 1개 이상 포함 ?? (긍정탐색) <-> (부정탐색)
		
		// (?=.*[A-Z])  대문자 1개 포함,  (?=.*[A-Z]){2} 2개   (?=.*[A-Z]){1,}  1개이상
		
		String password = "QWERqwer1234!@#$";

		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z!@#$0-9]{8,16}$";
	
		if(password.matches(regex)) {
			System.out.println("올바른 비밀번호입니다");
		}
		else {
			System.out.println("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
		}
	}

}
