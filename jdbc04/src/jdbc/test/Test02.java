package jdbc.test;

import jdbc.dao.SubjectDao;
import jdbc.dto.SubjectDto;

public class Test02 {

	public static void main(String[] args) {
		 
//		수정
		SubjectDto dto = new SubjectDto();
		dto.setNo(1);
		dto.setName("테스트두번째");
		dto.setPeriod(90);
		dto.setPrice(100);
		dto.setType("오프라인");
		
		SubjectDao dao = new SubjectDao();
		boolean result = dao.update(dto);
		
		if(result) {
			System.out.println("수정완료");
		}
		else {
			System.out.println("수정할 대상이 없음");
		}
	}

}
