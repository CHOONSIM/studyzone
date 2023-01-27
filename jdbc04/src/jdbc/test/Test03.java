package jdbc.test;

import jdbc.dao.SubjectDao;

public class Test03 {

	public static void main(String[] args) {
		 
//		삭제
		int no = 1;
		
		SubjectDao dao = new SubjectDao();
		boolean result = dao.delete(no);
		
		if(result) {
			System.out.println("삭제완료");
		}
		else {
			System.out.println("삭제할 대상이 없음");
		}
	}

}
