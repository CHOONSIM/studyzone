package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test03 {

	public static void main(String[] args) {
		 
		//데이터
		int no = 40;
		String name = "자바초급과정";
		int period = 60;
		int price = 800000;
		String type = "오프라인";
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		String sql = "update subject set name=?, period=?, price=?, type=? where no=?";
		Object[] param = {name, period, price, type, no};
		
		int count = jdbcTemplate.update(sql, param);
		
		if(count > 0) {
			System.out.println("수정완료");
		}
		else {
			System.out.println("대상이 없음");
		}
		
	}

}
