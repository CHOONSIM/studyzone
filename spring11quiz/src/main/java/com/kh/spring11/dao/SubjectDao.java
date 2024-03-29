package com.kh.spring11.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.SubjectDto;

@Repository
public class SubjectDao {
	
//		등록
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(SubjectDto dto) {
		String sql = "insert into subject(no,name,period,price,type) values(subject_seq.nextval,?,?,?,?)";
		Object[] param = {dto.getName(), dto.getPeriod(), dto.getPrice(), dto.getType()};
		jdbcTemplate.update(sql,param);
	}
	
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
	
//		목록
	public List<SubjectDto> selectList(){
		String sql = "select*from subject order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
//		검색
	public List<SubjectDto> selectList(String column, String keyword){
		String sql = "select*from subject where instr(#1,?) > 0";
		sql = sql.replace("#1", column);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	 
//		상세
	public SubjectDto selectOne(int no) {
		String sql = "select*from subject where no = ? ";
		Object[] param = {no};
		List<SubjectDto> list = jdbcTemplate.query(sql, mapper, param);
		return list.isEmpty() ? null : list.get(0);	

	}
	
//		수정
	public boolean update(SubjectDto dto) {
		String sql = "update subject set name=?, period=?, price=?, type=? where no=?";
		Object[] param = {dto.getName(), dto.getPeriod(), dto.getPrice(), dto.getType(), dto.getNo()};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
//		삭제
	public boolean delete(int no) {
		String sql = "delete subject where no=?";
		Object[] param = {no};
		return jdbcTemplate.update(sql, param) > 0;
	}

	
}
