package jdbc.test;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test05 {
 
	public static void main(String[] args) {
		
		// 사용자가 입력한 정보를 토대로 mobile 테이블에 데이터를 추가
		
		// 데이터 준비
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("통신사를 입력하세요");
		String telecom = sc.nextLine();
		System.out.println("금액을 입력하세요");
		int price = sc.nextInt();
		System.out.println("할부개월 수를 입력하세요, 0:미설정");
		Integer month = sc.nextInt();			// null을 넣으려면 Integer 사용 ,int X
		sc.close();
		
		if(month == 0) {
			month = null;
		}
		//Spring JDBC
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh11");
		dataSource.setPassword("kh11");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		String sql = "insert into mobile(name, telecom, price, month) "
				+ "values(?, ?, ?, ?)";
		
		Object[] param = {name, telecom, price, month};
		
		jdbcTemplate.update(sql, param);
		
		System.out.println("실행되었습니다.");
		
		
	}

}
