package jdbc.test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02 {

	public static void main(String[] args) {
		
		/*
		 *  정적 SQL 방식
			- SQL 구문을 직접 다 만들어서 전송하는 방식
		 	- 단점 : 구문이 지저분함, 못쓰는 글자가 있음, 보안에 최악(SQL Injection)
		 */
		
		
		// 데이터 준비
		int rank = 2;
		String name = "리오넬 메시";
		String nation = "아르헨티나";
		int goal = 7;
		
		//Spring JDBC
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh11");
		dataSource.setPassword("kh11");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		String sql = "insert into worldcup(rank,name,nation,goal) "
				+ "values("+rank+", '"+name+"', '"+nation+"',"+goal+")";
		
		jdbcTemplate.update(sql);
		
		System.out.println("실행되었습니다.");
	}

}
