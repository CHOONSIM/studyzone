package jdbc.test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test01 {
	public static void main(String[] args) {
		
		/*
			Spring을 이용한 JDBC 코드구현
		
		 	목표 : worldcup 테이블에 데이터 한 줄을 insert 하는 것
			- 자바에서 데이터를 이용한 구문을 준비
			- 통신을 통해 데이터베이스에 접속
			- 구문을 전송하고 실행
			
			insert into worldcup(rank,name,nation,goal)
			values(1,'음바페','프랑스',8);
			
			접속 도구 생성
		*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
		
		dataSource.setUsername("kh11");		//계정이름
		dataSource.setPassword("kh11"); 	//계정비밀번호
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); 	//오라클 드라이버 정보(내가 쓸 데이터베이스 종류)
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");	//DB주소 등록 (localhost IP주소)
		
		//명령 실행 도구 생성
		JdbcTemplate jdbcTemplate = new JdbcTemplate();		//jdbcTemplate 전송도구
		jdbcTemplate.setDataSource(dataSource);
		
		System.out.println("도구 준비 완료");
		
		//SQL 명령 준비
		String sql = "insert into worldcup(rank,name,nation,goal)"
				+ "values(1,'음바페','프랑스',8)";
		
		//실행
		jdbcTemplate.update(sql);
		
		System.out.println("실행이 되었습니다.");
	}
}
