package jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.SubjectDto;
import jdbc.util.JdbcUtils;

public class SubjectDao {
	private RowMapper<SubjectDto> mapper = new RowMapper<SubjectDto>() {

		@Override
		public SubjectDto mapRow(ResultSet rs, int itx) throws SQLException {
			SubjectDto dto = new SubjectDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setPeriod(rs.getInt("period"));
			dto.setPrice(rs.getInt("price"));
			dto.setType(rs.getString("type"));
			return dto;
		}
		
	};
	
//	등록
	public void insert(SubjectDto dto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "insert into subject(no,name,period,price,type) values(subject_seq.nextval,?,?,?,?)";
		Object[] param = {dto.getNo(), dto.getName(), dto.getPeriod(), dto.getPrice(), dto.getType()};
		jdbcTemplate.update(sql,param);
	}
	
//	목록
	public List<SubjectDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select*from subject order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
//	검색
	public List<SubjectDto> selectList(String column, String keyword){
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select*from subject where instr(#1,?) > 0 order by #1 asc";
		sql = sql.replace("#1", column);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
//	상세
	public SubjectDto selectOne(int no) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select * from subject where no = ?";
		Object[] param = {no};
		List<SubjectDto> list = jdbcTemplate.query(sql, mapper, param);
		if(list.isEmpty()) {
			return null;
		}
		else {
			return list.get(0);
		}
	}
	
//	수정
	public boolean update(SubjectDto dto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "update subject set name=?, period=?, price=?, type=? where no=?";
		Object[] param = {dto.getName(), dto.getPeriod(), dto.getPrice(), dto.getType(), dto.getNo()};
		
		int result =jdbcTemplate.update(sql, param);
		return result > 0;
	}
	
//	삭제
	public boolean delete(int no) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "delete subject where no = ?";
		Object[] param = {no};
		
		int result =jdbcTemplate.update(sql, param);
		return result > 0;
	}
}
