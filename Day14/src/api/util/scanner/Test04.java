package api.util.scanner;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
//		목표 : 단어 형태와 줄 단위 입력을 같이 사용하려면?
//		- .next() 계열을 사용 후 .nextLine() 메소드를 부르면 입력이 안됨
//		- 사리에 .nextLine()을 1회 추가
		
		
//		50\nhello\n 입력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int a = sc.nextInt();			//50 입력		\n를 쓰레기로 봄
		
		System.out.print("단어 입력 : ");
		String b = sc.next();			//hello 입력	\n를 쓰레기로 봄
		
		//이전 명령에서 남긴 쓰레기를 제거
		sc.nextLine();                  //앞에서 남은 쓰레기 처리를 여기서 해줌
		
		System.out.print("문장 입력 : ");
		String c = sc.nextLine();		//\n 엔터로 끝남("")	\n를 쓰레기로 안봄
		
		sc.close();
		
		System.out.println();
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}

}
