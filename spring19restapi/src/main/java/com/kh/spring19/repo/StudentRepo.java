package com.kh.spring19.repo;

import java.util.List;

import com.kh.spring19.dto.StudentDto;

public interface StudentRepo {

	void insert(StudentDto dto);
	List<StudentDto>selectList();
	StudentDto selectOne(int no);
	boolean update(StudentDto dto);
	boolean delete(int no);
}
