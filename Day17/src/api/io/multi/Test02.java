package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) throws IOException {
		
//		멀티 바이트 입력
//		준비물 : 출력의 반대
		
		File target = new File("temp","multi.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream combine = new DataInputStream(buffer);
		
//		[프로그램] <- combine <- buffer <- stream <- target <- [multi.kh]
		
//		주의 : 반드시 출력순서, 형태에 맞게 입력해야 한다
		boolean a = combine.readBoolean();
		byte b = combine.readByte();
		int c = combine.readInt();
		char d = combine.readChar();
		long e = combine.readLong();
		float f = combine.readFloat();
		double g = combine.readDouble();
		
		combine.close();
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		System.out.println("f = " + f);
		System.out.println("g = " + g);
		

	}

}
