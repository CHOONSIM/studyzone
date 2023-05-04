package com.kh.spring22.repo;

import java.util.List;

import com.kh.spring22.dto.PaymentDto;

public interface PaymentRepo {
	
	int sequence();
	void save(PaymentDto dto);
	List<PaymentDto> selectAll();
	List<PaymentDto> selectByMember(String memberId);
	PaymentDto find(int paymentNo);
	void cancelRemain(int paymentNo);	// 삭제가 아니라 update 기능
}
