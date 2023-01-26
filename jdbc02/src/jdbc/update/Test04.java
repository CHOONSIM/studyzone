package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test04 {

	public static void main(String[] args) {
		 
		//데이터
		int no = 2;
		String name = "아무개일";
		int korean = 100;
		int english = 100;
		int math = 10;
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		String sql = "update student set name=?, korean=?, english=?, math=? where no=?";
		Object[] param = {name, korean, english, math, no};
		
		int count = jdbcTemplate.update(sql, param);
		
		if(count > 0) {
			System.out.println("수정완료");
		}
		else {
			System.out.println("실행대상이 없음");
		}

	}

}
