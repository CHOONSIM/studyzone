package com.kh.spring19.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.dto.StudentDto;

@Repository
public class StudentRepoImpl implements StudentRepo{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(StudentDto dto) {
		sqlSession.insert("student.add",dto);
	}

	@Override
	public List<StudentDto> selectList() {
		return sqlSession.selectList("student.selectList");
	}

	@Override
	public StudentDto selectOne(int no) {
		return sqlSession.selectOne("student.selectOne",no);
	}

	@Override
	public boolean update(StudentDto dto) {
		return sqlSession.update("student.edit",dto)>0;
	}

	@Override
	public boolean delete(int no) {
		return sqlSession.delete("student.remove",no)>0;
	}
	
}
