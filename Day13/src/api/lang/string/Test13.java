package api.lang.string;

public class Test13 {

	public static void main(String[] args) {
		
		//목표 : 기본자료형과 문자열 사이의 변환
		
		// - 100을 "100"으로 만들 수 있는가? 반대는 가능?
		// - 통신(입출력)에서는 int나 double같은 데이터는 전송이 불가능
		// - 네트워크에서는 기본 전송단위가 패킷(packet)인데 크기가 1byte
		// - 문자열로 변환하여 전송하고 수신하여 되돌리는 경우가 비일비제
		
		//원시형을 String으로 변환
		int a = 100;
		//String b = a;
		String b = "" + a; //편법 : 문자열 + 데이터 = 문자열
		String c = String.valueOf(a); //정공법 : 문자열에서 제공하는 메소드 사용  valueOf-오버로딩
		
		//int로 변환
		String d = "200";
		//int e = d;
		int e = Integer.parseInt(d);
		System.out.println(e);

	}

}
