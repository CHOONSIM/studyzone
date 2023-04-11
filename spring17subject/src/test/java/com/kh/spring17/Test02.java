package com.kh.spring17;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring17.dto.SubjectDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void Test() {
		int no=1;
//		SubjectDto dto=sqlSession.selectOne("subject.selectOne",no);
		SubjectDto dto=sqlSession.selectOne("subject.listOrFind",no);

		log.debug("dto={}", dto);
	}
}
