package com.kh.spring18;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring18.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class Test01 {
	
	@Autowired
	private SqlSession sqlSession;
	

	public void test1() {
		List<MemberDto>list=sqlSession.selectList("member.complexSearch");
		for(MemberDto dto : list) {
			log.debug("dto={}", dto);
		}	
	}
	
	@Test
	public void test2() {
		Map<String, Object>param = new HashMap<>();
//		param.put("memberId","user");
//		param.put("memberNick", "유저");
//		param.put("memberLevelList", List.of("일반회원","우수회원","관리자"));
//		param.put("memberEmail", "kh.com");
//		param.put("memberBirth", "2000");
//		param.put("memberTel", "01055550169");
//		param.put("memberAddress", "서울시");
//		param.put("minPoint", "100");
//		param.put("maxPoint", "10000");
//		param.put("beginJoinDate", "2023-02-08");
//		param.put("endJoinDate", "2023-02-09");
//		param.put("searchLoginDays", 30);
		param.put("orderList", List.of(
					"member_join desc",
					"member_point desc"
				));
		List<MemberDto>list=sqlSession.selectList("member.complexSearch", param);
		log.debug("개수={}",list.size());
//		for(MemberDto dto : list) {
//			log.debug("dto={}", dto);
//		}
	}
}
