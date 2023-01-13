package api.lang.string;

public class Test11 {
	public static void main(String[] args) {
		
		//목표 : 비밀번호 검사식 만들기
		// - 반드시 1개 이상 포함 ?? (긍정탐색) <-> (부정탐색)
		
		// (?=.*[A-Z])  대문자 1개 포함,  (?=.*[A-Z]){2} 2개   (?=.*[A-Z]){1,}  1개이상
		
		String password = "QWERqwer1234!@#$";
		
		int lower = 0, upper = 0, number = 0, special = 0;
		
		for(int i=0; i<password.length(); i++){
			char ch = password.charAt(i);
			//System.out.println(ch);
			if(ch >='A'&&ch <='Z') {  //대문자라면
				upper++;
			}
			else if(ch >= 'a'&& ch<='z') {  //소문자라면
				lower++;
			}
			else if(ch >= '0'&&ch<='9') {  //숫자라면
				number++;
			}
			else if(ch == '!' || ch =='@') {   //특수문자라면  equals는 char가 원시적이여서 사용 X
				special++;
			}
		}
		
		String regex = "^[A-Za-z!@#$0-9]{8,16}$";
		boolean must = lower > 0 && upper > 0 && number > 0 && special > 0;
		if(password.matches(regex) && must) {
			System.out.println("올바른 비밀번호입니다");
		}
		else {
			System.out.println("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
		}
	}

}
