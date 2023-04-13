package com.kh.spring16;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dto.PocketmonDto;

import lombok.extern.slf4j.Slf4j;

// 목표 : myBatis를 이용한 pocketmon 조회
@Slf4j
@SpringBootTest
public class Test01 {
	
	//SqlSession은 myBatis에서 제공하는 데이터베이스 실행 도구 (JDBC 대체)
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
//		List<PocketmonDto>list = sqlSession.selectList("pocketmon.selectList");
		List<PocketmonDto>list = sqlSession.selectList("pocketmon.listOrFind");
		for(PocketmonDto dto : list) {
		log.debug("Dto ={}",dto);
		}
	}
}
