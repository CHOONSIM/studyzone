package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Test06_1 {

	public static void main(String[] args) throws IOException {
		
		File target = new File("temp", "note.kh");
		FileReader fr = new FileReader(target);
		BufferedReader br = new BufferedReader(fr);
		
		StringBuffer buffer = new StringBuffer();
		
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			System.out.println("line = "+line);
		}
		br.close();
		
		System.out.println(buffer.toString());
		
		}

	}


