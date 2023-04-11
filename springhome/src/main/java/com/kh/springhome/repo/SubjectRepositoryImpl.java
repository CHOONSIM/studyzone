package com.kh.springhome.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kh.springhome.dto.SubjectDto;

// 과목 Spring JDBC 구현체
public class SubjectRepositoryImpl implements SubjectRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<SubjectDto> mapper = new RowMapper<SubjectDto>() {
		
		@Override
		public SubjectDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			SubjectDto dto = new SubjectDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setPeriod(rs.getInt("period"));
			dto.setPrice(rs.getInt("price"));
			dto.setType(rs.getString("type"));
			return dto;
		}
	};

	@Override
	public void insert(SubjectDto subjectDto) {
		String sql = "insert into subject(no,name,period,price,type) values(subject_seq.nextval,?,?,?,?)";
		Object[] param = {subjectDto.getName(), subjectDto.getPeriod(), subjectDto.getPrice(), subjectDto.getType()};
		jdbcTemplate.update(sql,param);
	}

	@Override
	public List<SubjectDto> selectList() {
		String sql = "select*from subject order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public SubjectDto selectOne(int no) {
		String sql = "select*from subject where no = ? ";
		Object[] param = {no};
		List<SubjectDto> list = jdbcTemplate.query(sql, mapper, param);
		return list.isEmpty() ? null : list.get(0);	
	}

	@Override
	public boolean update(SubjectDto subjectDto) {
		String sql = "update subject set name=?, period=?, price=?, type=? where no=?";
		Object[] param = {subjectDto.getName(), subjectDto.getPeriod(), subjectDto.getPrice(), subjectDto.getType(), subjectDto.getNo()};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public boolean delete(int no) {
		String sql = "delete subject where no=?";
		Object[] param = {no};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public List<SubjectDto> selectList(String column, String keyword) {
		String sql = "select*from subject where instr(#1,?) > 0";
		sql = sql.replace("#1", column);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
}
