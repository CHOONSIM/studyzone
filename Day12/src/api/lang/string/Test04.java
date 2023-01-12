package api.lang.string;

public class Test04 {
	public static void main(String[] args) {
		
		//문자열을 new를 써서 만드는 것과 아닌 것의 차이
		
		String a = "hello";
		String b = "hello";
		String c = new String("hello");
		String d = new String("hello");
		
		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(c == d);
		System.out.println(d == a);
	}

}
