package jdbc.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// Spring JDBC에 사용하는 도구들을 생성해주는 유틸리티
// - static 메소드로 구현해서 간단하게 호출하여 사용 가능하도록 구현
public class JdbcUtils {
	
	//계정 및 연결 주소를 상수 형태로 보관
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERNAME = "kh11";
	public static final String PASSWORD = "kh11";
	
	// 연결 객체 생성 메소드
	// public static 반환형 이름(매개변수)
	public static DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}
	
	// 명령 실행 객체 생성 메소드
	public static JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

}
