package com.kh.spring12.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.spring12.dto.BoardDto;

@Repository
public class BoardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<BoardDto>mapper = new RowMapper<BoardDto>() {

		@Override
		public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardDto boardDto = new BoardDto();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardTime(rs.getDate("board_time"));
			boardDto.setBoardHead(rs.getString("board_head"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardLike(rs.getInt("board_like"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			return boardDto;
		}
	
};
//	top n query
	public List<BoardDto> selectListPaging(int page, int size){
		int end = page * size;
		int begin = end - (size-1);
		String sql = "select * from("
				+ "select tmp .*, rownum rn from("
				+ "select*from board order by board_no asc"
				+ ")tmp"
				+ ")where rn between ? and ?";
		Object[] param = {begin,end};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
//	count
	public int selectCount() {
		String sql = "select count(*) from board";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

//	목록
	public List<BoardDto> selectList(){
		String sql ="select*from board order by board_no asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
//	검색
	public List<BoardDto> selectList(String column, String keyword){
		String sql = "select*from board where instr(#1,?)>0";
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
//	입력
	@GetMapping("/board/write")
		public String boardWrite() {
			return"/WEB-INF/views/board/write.jsp";
	}
	
	
}
