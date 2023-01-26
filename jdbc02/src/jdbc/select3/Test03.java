package jdbc.select3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.StudentDto;
import jdbc.util.JdbcUtils;

public class Test03 {

	public static void main(String[] args) {
		
		int no = 10;
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		String sql = "select * from student where no=?";
		Object[] param = {no};
		
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
		
		if(list.isEmpty()) {
			System.out.println("해당 내용이 없습니다");
		}
		else {
			StudentDto dto = list.get(0);
			System.out.println(dto.getNo());
			System.out.println("이름 : "+dto.getName());
			System.out.println("국어 : "+dto.getKorean());
			System.out.println("영어 : "+dto.getEnglish());
			System.out.println("수학 : "+dto.getMath());
		}

	}

}
