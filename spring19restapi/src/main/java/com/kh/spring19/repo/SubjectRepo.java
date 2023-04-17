package com.kh.spring19.repo;

import java.util.List;

import com.kh.spring19.dto.SubjectDto;

public interface SubjectRepo {
	void insert(SubjectDto dto);
	List<SubjectDto>selectList();
	SubjectDto selectOne(int no);
	boolean update(SubjectDto dto);
	boolean delete(int no);
}
