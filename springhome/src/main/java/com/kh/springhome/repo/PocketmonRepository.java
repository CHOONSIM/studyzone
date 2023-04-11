package com.kh.springhome.repo;

import java.util.List;

import com.kh.springhome.dto.PocketmonDto;

public interface PocketmonRepository {
	void insert(PocketmonDto pocketmonDto);
	List<PocketmonDto> selectList();
	PocketmonDto selectOne(int no);
	boolean update(PocketmonDto pocketmonDto);
	boolean delete(int no);
}
