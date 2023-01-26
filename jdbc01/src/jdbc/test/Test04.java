package jdbc.test;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test04 {
 
	public static void main(String[] args) {
		
		// 사용자가 입력한 정보를 토대로 pocketmon 테이블에 데이터를 추가
		
		// 데이터 준비
		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 입력하세요");
		int no = sc.nextInt();
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		System.out.println("타입을 입력하세요");
		String type = sc.next();
		
		sc.close();
		// nextInt(); 에서 nextLine(); 으로 넘어가면 중간에 sc.nextLine(); 추가(짬통)
		
		//Spring JDBC
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh11");
		dataSource.setPassword("kh11");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		String sql = "insert into pocketmon(no,name,type) "
				+ "values(?, ?, ?)";
		
		Object[] param = {no, name, type};
		
		jdbcTemplate.update(sql, param);
		
		System.out.println("실행되었습니다.");
		
	}

}
