package jdbc.test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03 {
 
	public static void main(String[] args) {
		
		/*
		 *  동적 SQL 방식
			- 구문 완성을 위한 재료만 전달, 도구가 알아서 내부적으로 변환 후 실행
		 	- 장점 : 정적SQL의 단점을 모두 해결
		 	- 단점 : 완성된 구문을 볼 수 없음
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
				+ "values(?, ?, ?, ?)";
		
		// 배열을 만들어서 ?와 순서, 개수가 동일하게 데이터를 설정
		// Object[] param = new Object[] {rank, name, nation, goal};
		Object[] param = {rank, name, nation, goal};
		
		jdbcTemplate.update(sql, param);
		
		System.out.println("실행되었습니다.");
	}

}
