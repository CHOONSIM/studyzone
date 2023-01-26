package jdbc.select2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.PocketmonDto;
import jdbc.util.JdbcUtils;

public class Test01 {

	public static void main(String[] args) {
		
		// 검색
		// ex) 이름의 일부분만 입력하면 유사한 항목을 조회하여 출력
		
		// 데이터 준비
		String keyword = "파";
		
		// JDBC
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		
		// String sql = "select * from pocketmon where instr(name,'상해') > 0";
		String sql = "select * from pocketmon where instr(name, ?) > 0";
		Object[] param = {keyword};
		
		RowMapper<PocketmonDto> mapper = new RowMapper<PocketmonDto>() {
			
			@Override
			public PocketmonDto mapRow(ResultSet rs, int arg1) throws SQLException {
				PocketmonDto dto = new PocketmonDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setType(rs.getString("type"));
				return dto;
			}
		};
		List<PocketmonDto> list = jdbcTemplate.query(sql, mapper, param);
		System.out.println("검색결과 : " + list.size());
		
		for(PocketmonDto dto : list) {
			System.out.println(dto.getName());
		}
	}

}
