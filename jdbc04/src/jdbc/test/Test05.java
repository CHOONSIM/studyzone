package jdbc.test;

import jdbc.dao.SubjectDao;
import jdbc.dto.SubjectDto;

public class Test05 {

	public static void main(String[] args) {
		
//		상세
		int no = 1;
		
		SubjectDao dao = new SubjectDao();
		SubjectDto dto = dao.selectOne(no);

		if(dto == null) {
			System.out.println("검색한 번호의 데이터가 없습니다.");
		}
		else {
			System.out.println(dto);
		}
	}

}
