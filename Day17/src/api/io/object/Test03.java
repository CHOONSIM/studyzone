package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) throws IOException {
		
		List <String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		
		
		File target = new File("temp", "input.kh");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream mixer = new ObjectOutputStream(buffer);
		
		
	
			while(true) {
				System.out.print("단어 입력 : ");
				String word = sc.nextLine();
				if(word.equals("종료")) break;
				list.add(word);
			}
			mixer.writeObject(list);
			
		
		mixer.close();
		System.out.println("저장 완료");

	}

}
