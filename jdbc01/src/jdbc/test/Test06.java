package jdbc.test;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("<학생 성적>");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("국어점수 : ");
		double korean = sc.nextDouble();
		System.out.print("영어점수 : ");
		double english = sc.nextDouble();
		System.out.print("수학점수 : ");
		double math = sc.nextDouble();
		
		sc.close();
		
		//JDBC
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh11");
		dataSource.setPassword("kh11");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		String sql = "insert into student(no,name,korean,english,math) "
				+ "values(student_seq.nextval,?,?,?,?)";
		Object[] param = {name,korean,english,math};
		
		jdbcTemplate.update(sql,param);
		
		System.out.println("실행");
		
		

	}

}