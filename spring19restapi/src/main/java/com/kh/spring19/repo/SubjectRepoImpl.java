package com.kh.spring19.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.dto.SubjectDto;

@Repository
public class SubjectRepoImpl implements SubjectRepo{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(SubjectDto dto) {
		sqlSession.insert("subject.add",dto);
	}

	@Override
	public List<SubjectDto> selectList() {
		return sqlSession.selectList("subject.selectList");
	}

	@Override
	public SubjectDto selectOne(int no) {
		return sqlSession.selectOne("subject.selectOne",no);
	}

	@Override
	public boolean update(SubjectDto dto) {
		return sqlSession.update("subject.edit",dto)>0;
	}

	@Override
	public boolean delete(int no) {
		return sqlSession.delete("subject.remove",no)>0;
	}
	
}
