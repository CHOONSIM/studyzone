package jdbc.select3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.SubjectDto;
import jdbc.util.JdbcUtils;

public class Test02 {

	public static void main(String[] args) {
		
		// 데이터준비
		int no = 41;
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select*from subject where no=?";
		Object[] param = {no};
		
		RowMapper<SubjectDto> mapper = new RowMapper<SubjectDto>() {

			@Override
			public SubjectDto mapRow(ResultSet rs, int arg1) throws SQLException {
				SubjectDto dto = new SubjectDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPeriod(rs.getInt("period"));
				dto.setPrice(rs.getInt("price"));
				dto.setType(rs.getString("type"));
				return dto;
			}
			
		};
		List<SubjectDto> list = jdbcTemplate.query(sql, mapper, param);
		if(list.isEmpty()) {
			System.out.println("해당 내용이 없습니다");
		}
		else {
			SubjectDto dto = list.get(0);		//꺼내야함
			System.out.println(dto.getNo());
			System.out.println(dto.getName());
			System.out.println(dto.getPeriod());
			System.out.println(dto.getPrice());
			System.out.println(dto.getType());
		}
		
	}

}
