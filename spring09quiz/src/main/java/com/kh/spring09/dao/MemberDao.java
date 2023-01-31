package com.kh.spring09.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;

@Repository
public class MemberDao {
	private RowMapper<MemberDto> mapper = new RowMapper<MemberDto>() {
		
		@Override
		public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberDto dto = new MemberDto();
			dto.setMemberId(rs.getString("member_id"));
			dto.setMemberPw(rs.getString("member_pw"));
			dto.setMemberNick(rs.getString("member_nick"));
			dto.setMemberTel(rs.getString("member_tel"));
			dto.setMemberEmail(rs.getString("member_email"));
			dto.setMemberBirth(rs.getString("member_birth"));
			dto.setMemberPost(rs.getString("member_post"));
			dto.setMemberBasicAddr(rs.getString("member_basic_addr"));
			dto.setMemberDetailAddr(rs.getString("member_detail_addr"));
			dto.setMemberLevel(rs.getString("member_level"));
			dto.setMemberPoint(rs.getInt("member_point"));
			dto.setMemberJoin(rs.getDate("member_join"));
			dto.setMemberLogin(rs.getDate("member_login"));
			return dto;
		}
		
	};
	
//		등록
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void newbie(MemberDto dto) {
		String sql = "insert into member(member_id, member_pw, member_nick, member_tel, member_email, member_birth, member_post, "
				+ "member_basic_addr, member_detail_addr, member_level, member_point, member_join) "
				+ "values(?,?,?,?,?,?,?,?,?,'준회원',0,sysdate,null)";
		Object[] param = {dto.getMemberId(), dto.getMemberPw(), dto.getMemberNick(), dto.getMemberTel(), dto.getMemberEmail(), dto.getMemberBirth(), dto.getMemberPost(), 
				dto.getMemberBasicAddr(), dto.getMemberDetailAddr(), dto.getMemberLevel(), dto.getMemberPoint(), dto.getMemberJoin()};
		jdbcTemplate.update(sql,param);
	}
	
	
//		목록
	public List<MemberDto> selectList(){
		String sql = "select*from member order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
//		검색
	public List<MemberDto> selectList(String column, String keyword){
		String sql = "select*from member where instr(#1,?) > 0";
		sql = sql.replace("#1", column);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
//		상세
	public MemberDto selectOne(String memberId) {
		String sql = "select*from member where member_id = ? ";
		Object[] param = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, mapper, param);
		return list.isEmpty() ? null : list.get(0);
	}
		
//		수정
	public boolean update(MemberDto dto) {
		String sql = "update member set (member_id, member_pw, member_nick, member_tel, member_email, member_birth, member_post, "
				+ "member_basic_addr, member_detail_addr, member_level, member_point, member_join";
		Object[] param = {dto.getMemberId(), dto.getMemberPw(), dto.getMemberNick(), dto.getMemberEmail(), dto.getMemberBirth(), dto.getMemberPost(), 
				dto.getMemberBasicAddr(), dto.getMemberDetailAddr(), dto.getMemberLevel(), dto.getMemberPoint(), dto.getMemberJoin(), dto.getMemberLogin()};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
//		삭제
	public boolean delete(String memberId) {
		String sql = "delete member where member_id = ?";
		Object[] param = {memberId};
		return jdbcTemplate.update(sql, param) > 0;
	}
}
