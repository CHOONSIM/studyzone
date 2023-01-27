package jdbc.test;

import java.util.List;

import jdbc.dao.SubjectDao;
import jdbc.dto.SubjectDto;

public class Test04 {

	public static void main(String[] args) {
		
//		목록/검색
		String column = "type";
		String keyword = "오프";
		
		SubjectDao dao = new SubjectDao();
		List<SubjectDto> list;
		if(column != null && keyword != null) {
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		
		if(list.isEmpty()) {
			System.out.println("데이터 없음");
		}
		else {
			System.out.println("데인터 개수 : " + list.size());
			for(SubjectDto dto : list) {
				System.out.println(dto);
			}
		}
		

	}

}
