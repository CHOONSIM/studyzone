package jdbc.test;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test02 {

	public static void main(String[] args) {
		
//		 Pocketmon 수정
		 
//		 데이터 준비
		PocketmonDto dto = new PocketmonDto();
		dto.setNo(11);
		dto.setName("바꾼이름");
		dto.setType("바뀐타입");
		 
//		 JDBC
		PocketmonDao dao = new PocketmonDao();
		boolean result = dao.update(dto);
		
		if(result) {
			System.out.println("변경완료");
		}
		else {
			System.out.println("대상 없음");
		}
		
	}

}
