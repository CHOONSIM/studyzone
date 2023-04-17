package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dto.PocketmonDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test04 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void Test() {
		PocketmonDto dto = new PocketmonDto();
		dto.setNo(1);
		dto.setName("myBetis수정");
		dto.setType("타입");
		sqlSession.update("pocketmon.edit",dto);
	}
}
