package api.lang.string;

public class Test01 {

	public static void main(String[] args) {
		
		//java.lang.String 클래스
		
		//객체 생성
		String a = "hello";  //원래 사용하던 방법
		String b = new String("hello");
		
		char[] ch = new char[] {'h','e','l','l','o'};
		String c = new String(ch);
		
		//메소드 사용
		
		//글자수
		System.out.println(a.length());
		System.out.println(b.length());
		
		//비교
		System.out.println(a == b); //동일비교(의미없음)  (포장지가 같냐)
		System.out.println(a.equals(b)); //동등비교(글자가 같은지 비교)   (내용물이 같냐)
		
		//비교는 대소문자를 구분한다.
		String d = "Hello";
		System.out.println(a.equals(d));
		System.out.println(a.equalsIgnoreCase(d));  //대소문자 구분 무시
		
		//문자열은 전체가 아닌 일부만 비교하는 경우도 있다
		String e = "https://iei.or.kr";
		
		System.out.println(e.equals("http"));
		System.out.println(e.startsWith("http")); //시작검사
		
		System.out.println(e.endsWith("kr")); //종료검사
		
		System.out.println(e.contains("iei")); //포함검사
		
		System.out.println(e.indexOf("iei"));  //위치검사(0부터시작)
		
	}

}
