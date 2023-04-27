package com.kh.spring20.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring20.dto.SecurityDto;

@Repository
public class SecurityRepoImpl implements SecurityRepo{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(SecurityDto securityDto) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encrypt = encoder.encode(securityDto.getMemberPw());
		securityDto.setMemberPw(encrypt);
		
		sqlSession.insert("security.join",securityDto);
	}

}
