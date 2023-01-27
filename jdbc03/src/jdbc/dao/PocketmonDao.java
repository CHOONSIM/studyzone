package jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.PocketmonDto;
import jdbc.util.JdbcUtils;

// DAO(Data Access Object)
// - DB 작업 전담 처리 클래스
public class PocketmonDao {
	
	// Read에 필요한 RowMapper를 미리 생성
	private RowMapper<PocketmonDto> mapper = new RowMapper<PocketmonDto>() {

		@Override
		public PocketmonDto mapRow(ResultSet rs, int idx) throws SQLException {
			PocketmonDto dto = new PocketmonDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setType(rs.getString("type"));
			return dto;
		}
	};
	
	
	
//	  C(등록) - insert into pocketmon(no,name,type) values(?,?,?)
//		public void insert(int no, String name, String type)
		public void insert(PocketmonDto dto) {
			JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
			
			String sql = "insert into pocketmon(no,name,type) values(?,?,?)";
//			Java 13+에서 사용 가능한 여러줄 문자열 구문
//			String sql = """
//					insert into pocketmon(no,name,type) values(?,?,?)
//					""";
			Object[] param = {dto.getNo(), dto.getName(), dto.getType()};
			jdbcTemplate.update(sql,param);
		}

//	  R(목록)
//	  R(상세)
//	  U(수정) - update pocketmon set name =?, type=? where no =?
		public boolean update(PocketmonDto dto) {		//boolean, 수정이 되었는지 안되었는지
			JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
			String sql = "update pocketmon set name =?, type=? where no =?";
			Object[] param = {dto.getName(), dto.getType(), dto.getNo()};
			int result = jdbcTemplate.update(sql,param);
			return result > 0;

//	  D(삭제)

		}
}
