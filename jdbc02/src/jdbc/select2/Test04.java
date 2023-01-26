package jdbc.select2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.SubjectDto;
import jdbc.util.JdbcUtils;

public class Test04 {

	public static void main(String[] args) {
		
		//데이터
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 항목을 입력하세요.");
		String type = sc.next();
		System.out.println("검색할 키워드를 입력하세요");
		String keyword = sc.next();
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		String sql = "select*from subject where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", type);
		Object[] param = {keyword};

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
		System.out.println("검색결과 : " + list.size());
		
		if(list.isEmpty()) {
			System.out.println("검색결과가 존재하지 않습니다.");
		}
		else {
			System.out.println("검색 결과 : "+list.size()+"개");
		}
		
		for( SubjectDto dto : list) {
			System.out.println(dto.getName());
		}
		

	}

}
