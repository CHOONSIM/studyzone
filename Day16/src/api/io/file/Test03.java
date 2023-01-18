package api.io.file;

import java.io.File;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		
//		File a = new File("temp/hello3.txt");
		File a = new File("temp");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 : ");
		String input = sc.nextLine();
		
		if(a.isFile()) {
			System.out.println("<파일 정보>");
			System.out.println("파일 이름 : " + a.getName());
			System.out.println("파일 크기 : " + a.length());
		}
		else if(a.isDirectory()) {
			System.out.println("<디렉토리 정보>");
			System.out.println("디렉토리 이름 : " + a.getName());
			File[] files = a.listFiles();
			System.out.println("파일 : "+ files.length + " 개");
			for(File file : files) {
				if(a.length() == 0) {
					String name = ("폴더");
					System.out.println(file.getName() + " " + name);
				}
			}
		}
		else {
			System.out.println("대상이 존재하지 않습니다.");
			System.exit(-1);
		}

	}

}
