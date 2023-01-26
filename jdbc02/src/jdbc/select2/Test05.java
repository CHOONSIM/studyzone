package jdbc.select2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.StudentDto;
import jdbc.util.JdbcUtils;

public class Test05 {

	public static void main(String[] args) {
		
		//데이터
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 항목 : ");
		String type = sc.next();
		System.out.println("검색할 키워드 : ");
		String keyword = sc.next();
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		String sql = "select*from student where instr(#1,?) > 0";
		sql = sql.replace("#1", type);
		Object[] param = {keyword};
		
		RowMapper<StudentDto> mapper = new RowMapper<StudentDto>() {

			@Override
			public StudentDto mapRow(ResultSet rs, int arg1) throws SQLException {
				StudentDto dto = new StudentDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setKorean(rs.getInt("korean"));
				dto.setEnglish(rs.getInt("english"));
				dto.setMath(rs.getInt("math"));
				return dto;
			}
			
		};
		List<StudentDto> list = jdbcTemplate.query(sql, mapper, param);
		System.out.println("검색 결과 : " + list.size());
		
		if(list.isEmpty()) {
			System.out.println("검색결과가 존재하지 않습니다.");
		}
		else {
			System.out.println("검색 결과 : "+list.size()+"개");
		}
		
		for(StudentDto dto : list) {
			System.out.println(dto.getName());
		}
		

	}

}
