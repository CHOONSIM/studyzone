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
	private int blockSize = 10;
	
//	시작행번호 계산
	public int getBegin() {
		return page * size-(size-1);
	}
	
//	종료행번호 계산
	public int getEnd() {
//		return page*size;
		return Math.min(page*size,  count);
	}
	
//	전체 페이지 수
	public int getTotalPage() {
		return (count + size -1)/size;
	}
	
//	시작블록번호
	public int getStartBlock() {
		int value = (page-1) / blockSize*blockSize +1;
		return Math.min(value, getTotalPage());
	}
	
//	종료블록번호
	public int getFinishBlock() {
		return (page-1) / blockSize*blockSize + blockSize;
	}
	
//	첫 페이지인지
	public boolean isFirst() {
		return page == 1;
	}
	
//	마지막 페이지인지
	public boolean isLast() {
		return page == getTotalPage();
	}
	
//	[이전]이 나오는 조건 : 시작블록이 1보다 크면 (page가 size보다 크면)
	public boolean isPreview() {
		return getStartBlock() > 1;
	}
	
//	[다음]이 나오는 조건 : 종료블록이 마지막 페이지보다 작으면
	public boolean isNext() {
		return getFinishBlock() < getTotalPage();
	}
	
//	[이전]을 누르면 나올 페이지 번호
	public int getPrevPage() {
		return getStartBlock()-1;
	}
	
//	[다음]을 누르면 나올 페이지 번호
	public int getNextPage() {
		return getStartBlock()+1;
	}
}
