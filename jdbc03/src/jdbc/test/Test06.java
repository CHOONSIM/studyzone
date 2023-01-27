package jdbc.test;

import java.util.List;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test06 {

	public static void main(String[] args) {
		
//		Pocketmon 목록/검색 통합
		
//		데이터 준비
		String column = "name";
		String keyword = "파이";
		
//		JDBC
		PocketmonDao dao = new PocketmonDao();
//		List<PocketmonDto> list = 목록 or 검색;
		List<PocketmonDto> list;
//		if(column도 있고 keyword도 있으면) {
		if(column != null && keyword != null) {
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		
//		출력
		if(list.isEmpty()) {
			System.out.println("데이터가 없습니다.");
		}
		else {
			System.out.println("데이터 개수 : " + list.size());
			for(PocketmonDto dto : list) {
				System.out.println(dto);
			}
		}
	}

}
