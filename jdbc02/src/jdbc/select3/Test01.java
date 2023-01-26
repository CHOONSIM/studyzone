package jdbc.select3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.PocketmonDto;
import jdbc.util.JdbcUtils;

public class Test01 {

	public static void main(String[] args) {
		
		// 단일 조회(상세 조회)
		// - 단 하나의 데이터만 조회하기 위한 형태
		// - PK를 이용하여 조회
		
		// 데이터 준비(PK)
		int no = 1;
		
		//JDBC
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		String sql = "select*from pocketmon where no=?";
		Object[] param = {no};
		
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
		if(list.isEmpty()) {
			System.out.println("해당 캐릭터는 존재하지 않습니다.");
		}
		else {		//데이터가 1개라면
			PocketmonDto dto = list.get(0);
			System.out.println(dto.getNo());
			System.out.println(dto.getName());
			System.out.println(dto.getType());
			
		}
	}

}
