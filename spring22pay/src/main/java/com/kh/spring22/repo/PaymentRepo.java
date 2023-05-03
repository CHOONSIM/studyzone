package com.kh.spring22.repo;

import com.kh.spring22.dto.PaymentDto;

public interface PaymentRepo {
	
	int sequence();
	void save(PaymentDto dto);
}
