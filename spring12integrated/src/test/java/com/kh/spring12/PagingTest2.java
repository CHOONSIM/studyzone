package com.kh.spring12;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.vo.PaginationVO;

//	목표 : 
//	페이지번호, 크기, 검색항목, 키워즈 , 데이터 수를 알려주면
//	자동으로 불러와야 하는 데이터의 행 번호와 하단에 표시될 블록번호를 계산

@SpringBootTest
public class PagingTest2 {
	
	@Test
	public void test() {
		PaginationVO vo = new PaginationVO();
		
		vo.setPage(1);
		vo.setSize(10);
		vo.setCount(1200);
		
		System.out.println("시작행번호 =" + vo.getBegin());						// 시작행번호
		System.out.println("종료행번호 =" + vo.getEnd());							// 종료행번호
		System.out.println("전체 페이지 수	=" + vo.getTotalPage());			// 전체 페이지 수	
		System.out.println("시작블록번호 =" + vo.getStartBlock());			// 시작블록번호
		System.out.println("종료블록번호 =" + vo.getFinishBlock());			// 종료블록번호
		System.out.println("첫 페이지 =" + vo.isFirst());	
		System.out.println("마지막 페이지 =" + vo.isLast());	
	}
}
