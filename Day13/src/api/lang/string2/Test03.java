package api.lang.string2;

public class Test03 {
	public static void main(String[] args) {
		
		//StringBuilder 사용
		// - non-thread-safe 이므로 빠르지만 여러명이 동시에 접근하면 난장판이 된다
		// - 단일 사용자 환경이라면 이용을 추천
		
		StringBuilder builder = new StringBuilder();
		
		long start = System.currentTimeMillis();
		
		for(int i=0; i<100000; i++) {
			builder.append("☆");
		}
		
		long finish = System.currentTimeMillis();
		
		System.out.println(finish - start);
		
		//System.out.println(buffer.toString());
		}

}
