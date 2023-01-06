package oop.test1;

public class Test01 {
	public static void main(String[] args) {
		
		
		//객체
		
		//카톡 메세지 2개
		// - 낱개 데이터가 아니라 미리 만들어둔 Message 클래스의 객체물 생성
		
		Message m1 = new Message();
		//m1 ----> {writer:null , content:null , time=null , remain=0}    =  객체(인스턴스)
		
		m1.writer = "초롱초롱 라이언";
		m1.content = "언제와?";
		m1.time = "오후 03:03";
		m1.remain = 1;
		
		//System.out.println(m1); //리모컨 정보 필요없음
		System.out.println(m1.writer); //m1 대상에 있는 writer 접근 후 출력
		System.out.println(m1.content);
		System.out.println(m1.time);
		System.out.println(m1.remain);
		
		
		Message m2 = new Message();
		
		System.out.println(m2.writer);   //null
		System.out.println(m2.content);  //null
		System.out.println(m2.time);     //null
		System.out.println(m2.remain);   //0
	}

}
