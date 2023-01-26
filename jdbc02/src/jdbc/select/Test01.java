package jdbc.select;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test01 {

	public static void main(String[] args) {
		
		// Spring JDBC Select
		//	- insert, update, delete처럼 구현하면 원하는 결과를 얻을 수 없다
		
		// 데이터 준비(없음)
		
		// JDBC
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		String sql = "select * from pocketmon";
		
		int result = jdbcTemplate.update(sql);
		System.out.println("실행 완료");
		System.out.println("result = " + result);
		

	}

}
