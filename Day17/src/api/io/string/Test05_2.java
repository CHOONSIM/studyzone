package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test05_2 {

	public static void main(String[] args) throws IOException {
		
//		최적화
//		단점 종료할때까지 파일이 안생김
		
		StringBuffer buffer = new StringBuffer();

		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("문장 입력");
			String write = sc.nextLine();
			if(write.equals("종료")) break;

			buffer.append(write);
			buffer.append("\n"); 		
			
		}
		
		File target = new File("temp", "note.kh");
		FileWriter fw = new FileWriter(target);
		BufferedWriter bf = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bf);
		
		pw.write(buffer.toString());
		
		sc.close();
		pw.close();

	}

}
