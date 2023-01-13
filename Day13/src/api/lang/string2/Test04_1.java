package api.lang.string2;

public class Test04_1 {

	public static void main(String[] args) {

		//문자열에 보이스피싱 관련 단어가 포함되어있는지 감지하는 프로그램
		// - 검찰, 송금, 계좌, 돈, 납치, 아들, 딸
		
		String text = "안녕하세요 서부검찰청 보이스 검사입니다.";
		
		String[] filter = new String[] {
				"검찰", "송금", "계좌", "돈", "납치", "아들", "딸"
		};
		
		//filter를 이용해서 정규표현식을 생성
		StringBuffer buffer = new StringBuffer();
		buffer.append("(.*?)");
		buffer.append("(");
		
		
		for(int i=0; i<filter.length; i++) {
			buffer.append(filter[i]);
			if(i < filter.length-1) {
				buffer.append("|");
			}
		}
		buffer.append(")");
		buffer.append("(.*?)");
		
		String regex = buffer.toString();
		//System.out.println(regex);
		
		if(text.matches(regex)) {
			System.out.println(text);
			System.out.println("-----------------");
			System.out.println("주의 : 보이스피싱에 당하지 않게 조심하세요");
		}
		else {
			System.out.println(text);
		}

	}

}
