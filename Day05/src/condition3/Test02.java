package condition3;

public class Test02 {

	public static void main(String[] args) {
		//switch
		
		char key = 'w';
		
		//switch(검사항목)
		switch(key) {
		case 'w':
			System.out.println("앞으로 이동");
			break;//그만 실행하고 나가세요.
		case 'a':
			System.out.println("왼쪽으로 이동");
			break;
		case 's':
			System.out.println("뒤로 이동");
			break;
		default:
			System.out.println("오른쪽으로 이동");
		}

	}

}
