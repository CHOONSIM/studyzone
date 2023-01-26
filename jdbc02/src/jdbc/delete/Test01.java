package jdbc.delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test01 {

	public static void main(String[] args) {
		
		/*
		 Spring JDBC Delete
		 	- pk를 이용해서 단일 데이터를 삭제하는 형태로만 구현
		 	- 수정과 동일하게 결과 행 수를 토대로 삭제 성공/실패를 판정
		*/
		
		// 데이터 준비
		int no = 22;
		
		//JDBC
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		String sql = "delete pocketmon where no = ?";
		Object[] param = {no};
		
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			System.out.println("삭제 완료");
		}
		else {
			System.out.println("대상 없음");
		}
		
		
	}

}
