package jdbc.test;

import jdbc.dao.SubjectDao;
import jdbc.dto.SubjectDto;

public class Test01 {

	public static void main(String[] args) {

//		등록
		SubjectDto dto = new SubjectDto();
		
		dto.setName("테스트테스트");
		dto.setPeriod(60);
		dto.setPrice(1000000);
		dto.setType("혼합");
		
		SubjectDao dao = new SubjectDao();
		dao.insert(dto);
		
		System.out.println("등록완료");
	}

}
