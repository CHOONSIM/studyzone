package api.lang.string;

public class Test07_1 {

	public static void main(String[] args) {
		
		String name = "이름이";
		
		//계산 : 총 글자 수, 한글 글자 수
		boolean pass;
		int total = name.length();
		if(total >=2 && total <= 7) {
		int korean = 0;
		
		for(int i=0; i < total; i++) {
			char ch = name.charAt(i);
			if(ch >= '가' && ch <= '힣' ) {  //ch가 한글이라면
				korean++;
			}
		}
		//System.out.println("한글 : "+korean+"글자, 총 "+total+"글자");
		
		if(korean == total) {//모든 글자가 한글이라면
			//System.out.println("이름 설정이 완료되었습니다");
			pass = true;
		}
		else {
			//System.out.println("한글 2~7글자로 작성하세요");
			pass = false;
		}
	}
	else {
		//System.out.println("한글 2~7글자로 작성하세요");
		pass = false;
	}
	
	if(pass) {
		System.out.println("이름 설정이 완료되었습니다");
	}
	else {
		System.out.println("한글 2~7글자로 작성하세요");
	}
}
}