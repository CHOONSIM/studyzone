package com.kh.spring12.vo;

import lombok.Data;

//	VO(Value Object)
//	- 필요에 의해 특정 값들을 묶어서 사용하고 싶을 때 만드는 클래스
//	- DTO는 테이블과 같은 모양이어야 하지만 VO는 제약이 없다
//	- 등록하지 않고 일회용으로 사용한다

@Data
public class PaginationVO {
	private String column;
	private String keyword;
	private int page = 1;
	private int size = 10;
	private int count;
	
//	시작행번호 계산
	public int getBegin() {
		return page * size-(size-1);
	}
	
//	종료행번호 계산
	public int getEnd() {
//		return page*size;
		return Math.min(page*size,  count);
	}
}
