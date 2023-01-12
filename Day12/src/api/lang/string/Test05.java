package api.lang.string;

public class Test05 {
	public static void main(String[] args) {
		
		//문자열 편집
		// - 문자열은 불변(immutable) 속성을 가진다
		// - 한 번 만들어진 문자열은 바뀌지 않으며, 바꾸고 싶다면 새로 만들어야 한다
		
		//소문자 변경 : .toLowerCase()
		//대문자 변경 : .toUpperCase()
		
		String url = "WWW.NAVER.COM";
		System.out.println(url.toLowerCase());
		System.out.println(url);
		
		url = url.toLowerCase();
		System.out.println(url);
		
		String url2 = "            www.naver.com             ";
		url2 = url.trim();   //여백제거
		System.out.println(url2);
		
		String url3 = "www.google.com";
		System.out.println(url3.substring(4,10));  //4부터 9까지 짤라 나타냄
		System.out.println(url3.charAt(4));// 4위치의 글자를 추출(char)
		
		String text = "나는 피자가 좋아요";
		System.out.println(text.replace("피자","자바"));  //치환
	
	}

}
