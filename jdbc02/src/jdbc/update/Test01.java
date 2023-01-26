package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test01 {

	public static void main(String[] args) {
		 
	/*
		Spring JDBC update
		- pk(Primary Key)를 사용하여 하나의 행만 수정하도록 구문을 구현
		- update pocketmon set name = ?, type = ? where no = ?
		- 등록과 다른 점은 실행이 되더라도 적용 대상이 있거나 없을 수 있다는 것
	*/
		// 데이터 준비
		int no = 10;
		String name = "아무개";
		String type = "물";
		
		//Spring JDBC
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh11");
		dataSource.setPassword("kh11");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		String sql = "update pocketmon set name=?, type=? where no=?";
		Object[] param = {name,type,no};
		
		int count = jdbcTemplate.update(sql, param);
		System.out.println("count = " + count);
		
		if(count > 0) {
			System.out.println("수정완료");
		}
		else {
			System.out.println("실행은 하였으나 대상이 없음");
		}
	}

}
