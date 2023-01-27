package jdbc.test;

import jdbc.dao.PocketmonDao;

public class Test03 {

	public static void main(String[] args) {
		
//		Pocketmon 삭제
		
//		데이터 준비
		int no = 11;
		
//		JDBC
		PocketmonDao dao = new PocketmonDao();
		boolean result = dao.delete(no);
		
		if(result) {
			System.out.println("삭제완료");
		}
		else {
			System.out.println("대상 없음");
		}
	}

}
