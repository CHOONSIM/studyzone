package jdbc.select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.StudentDto;
import jdbc.util.JdbcUtils;

public class Test04 {

	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		String sql = "select * from student order by no asc";		//order by no asc (오름차순)
		
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
		List<StudentDto> list = jdbcTemplate.query(sql, mapper);
		System.out.println("데이터 개수 : " + list.size());
		
		for(StudentDto dto : list) {
			System.out.println(dto);
//			System.out.println(dto.getNo());
//			System.out.println(dto.getName());
//			System.out.println(dto.getKorean());
//			System.out.println(dto.getEnglish());
//			System.out.println(dto.getMath());
		}

	}

}
