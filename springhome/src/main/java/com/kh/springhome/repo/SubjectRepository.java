package com.kh.springhome.repo;

import java.util.List;

import com.kh.springhome.dto.SubjectDto;

// 과목 추상체
// - 외부에서 사용하는 대표 형태(간판, 목차)
public interface SubjectRepository {
	void insert(SubjectDto Dto);
	List<SubjectDto> selectList();
	List<SubjectDto> selectList(String column, String keyword);
	SubjectDto selectOne(int no);
	boolean update(SubjectDto Dto);
	boolean delete(int no);
}
