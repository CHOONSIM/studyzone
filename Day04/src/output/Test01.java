package output;
import java.lang.*;

public class Test01 {
	public static void main(String[] args) {
		//표준 출력(Standard Output)
		//- 표준 출력 통로(System.out)울 통해 데이터를 내보내는 행위 (->콘솔)
		//- System.out.println() - 내용을 1중 단위로 출력하는 명령
		//- System.out.print() - 내용을 그대로 출력하는 명령
		//- System.out.printf() - C언어 방식의 출력 명령(비추천)
		
		System.out.println("hello");
		System.out.println("goodbye");
		
		System.out.print("hello");   // System.out.println("hello\n");
		System.out.print("goodbye");
		
		System.out.printf("hello\n");
		System.out.printf("%d + %d = %d\n" , 10, 20, 30);
	}

}
