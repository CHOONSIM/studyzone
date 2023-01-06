package oop.test1;

//Java(JVM)에게 메세지란 이렇게 생겼다라고 알려주기 위해 만든 영역
// 메세지 = 작성자(String) + 내용(String) + 전송시각(String) + 안읽은사람수(int)
public class Message {
	
	
	//클래스
	
	//멤버필드 : 클래스를 구성하는 세부 데이터를 저장하는 변수
//	         : 클래스를 구성하는 데이터 저장소 
	
	String writer;    //메세지에는 작성자가 있어야합니다.
	String content;   //메세지에는 내용이 있어야합니다.
	String time;      //메세지에는 전송시각이 있어야합니다.
	int remain;    //메세지에는 안읽은 사람 수가 있어야합니다.

}
