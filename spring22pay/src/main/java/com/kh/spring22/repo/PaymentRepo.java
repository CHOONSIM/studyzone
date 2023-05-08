package com.kh.spring22.repo;

import java.util.List;

import com.kh.spring22.dto.PaymentDto;
import com.kh.spring22.vo.PaymentListVO;

public interface PaymentRepo {
	
	int sequence();
	void save(PaymentDto dto);
	List<PaymentDto> selectAll();
	List<PaymentDto> selectByMember(String memberId);
	PaymentDto find(int paymentNo);
	
	List<PaymentListVO> treeSelect();		//오버로딩
	List<PaymentListVO> treeSelect(String memberId);		//오버로딩
	
	void cancelRemain(int paymentNo);	// 전체 취소, 오버로딩
	void cancelRemain(int paymentNo, int itemTotal);		//금액 차감, 오버로딩
}
