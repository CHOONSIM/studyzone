package jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.MemberDto;
import jdbc.util.JdbcUtils;

public class MemberDao {
	private RowMapper<MemberDto> mapper = new RowMapper<MemberDto>(){

		@Override
		public MemberDto mapRow(ResultSet rs, int itx) throws SQLException {
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
			dto.setMemberJoin(rs.getString("member_join"));
			return dto;
		}
	};
	
//	등록
	public void insert(MemberDto dto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "insert into member(member_id, member_pw, member_nick, member_tel, member_email, member_birth, member_post, "
				+ "member_basic_addr, member_detail_addr, member_level, member_point, member_join) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param = {dto.getMemberId(), dto.getMemberPw(), dto.getMemberNick(), dto.getMemberTel(), dto.getMemberEmail(), dto.getMemberBirth(), dto.getMemberPost(), 
				dto.getMemberBasicAddr(), dto.getMemberDetailAddr(), dto.getMemberLevel(), dto.getMemberPoint(), dto.getMemberJoin()};
		jdbcTemplate.update(sql,param);
	}
	
//	목록
	public List<MemberDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select*from member order by member_id asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
//	검색
	public List<MemberDto> selectList(String column, String keyword){
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select*from member where instr(#1,?) > 0 order by #1 asc";
		sql = sql.replace("#1", keyword);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
//	추가
	public List<MemberDto> selectAuto(String column, String keyword){
		if(column != null && !column.equals("")
				&& keyword != null && !keyword.equals("")) 
			return selectList(column, keyword);
		else
			return selectList();
	}

	
//	상세
	public MemberDto selectOne(String memberId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select*from member where memberId = ?";
		Object[] param = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, mapper, param);
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}
	
//	수정
	public boolean update(MemberDto dto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "update member set member_id = ?, member_pw = ?, member_nick = ?, member_tel = ?, member_email = ?, member_birth = ?, member_post = ?,"
				+ " member_basic_addr = ?, member_detail_addr = ?, member_level = ?, member_point = ?, member_join = ?";
		Object[] param = {dto.getMemberId(), dto.getMemberPw(), dto.getMemberNick(), dto.getMemberTel(), dto.getMemberEmail(), dto.getMemberBirth(), 
				dto.getMemberPost(), dto.getMemberBasicAddr(), dto.getMemberDetailAddr(), dto.getMemberLevel(), dto.getMemberPoint(), dto.getMemberJoin()};
		int result = jdbcTemplate.update(sql, param);
		return result > 0;
	}
	
//	삭제
	public boolean delete(String memberId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "delete member where member_id = ?";
		Object[] param = {memberId};
		int result = jdbcTemplate.update(sql, param);
		return result > 0;
	}
}
