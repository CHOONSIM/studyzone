package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dto.PocketmonDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test03 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void Test() {
		PocketmonDto dto = new PocketmonDto();
		dto.setNo(999);
		dto.setName("999입력");
		dto.setType("logging");
		sqlSession.insert("pocketmon.add",dto);
	}
}
