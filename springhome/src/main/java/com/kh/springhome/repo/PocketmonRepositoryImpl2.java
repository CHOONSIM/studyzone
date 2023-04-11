package com.kh.springhome.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.springhome.dto.PocketmonDto;

@Repository
public class PocketmonRepositoryImpl2 implements PocketmonRepository {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(PocketmonDto pocketmonDto) {
		sqlSession.insert("pocektmon.add",pocketmonDto);
	}

	@Override
	public List<PocketmonDto> selectList() {
		return sqlSession.selectList("pocketmon.selectList");
	}

	@Override
	public PocketmonDto selectOne(int no) {
		return sqlSession.selectOne("pocketmon.selectOne",no);
	}

	@Override
	public boolean update(PocketmonDto pocketmonDto) {
		int result=sqlSession.update("pocketmon.edit",pocketmonDto);
		return result > 0;
	}

	@Override
	public boolean delete(int no) {
		int result=sqlSession.delete("pocketmon.delete",no);
		return result > 0;
	}
	
}
