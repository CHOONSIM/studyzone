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
		param.put("memberId","user");
		List<MemberDto>list=sqlSession.selectList("member.complexSearch", param);
		log.debug("개수={}",list.size());
//		for(MemberDto dto : list) {
//			log.debug("dto={}", dto);
//		}
	}
}
