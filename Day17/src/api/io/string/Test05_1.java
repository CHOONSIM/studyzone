package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test05_1 {

	public static void main(String[] args) throws IOException {
		

		Scanner sc = new Scanner(System.in);
		
		File target = new File("temp", "note.kh");
		FileWriter fw = new FileWriter(target);
		BufferedWriter bf = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bf);
		
		while(true) {
			System.out.println("문장 입력");
			String write = sc.nextLine();
			if(write.equals("종료")) break;

			pw.println(write);
			pw.flush(); 		//입력과 동시에 출력   (기존 : 버퍼로 모아서 출력)
		}
		
		sc.close();
		pw.close();

	}

}
