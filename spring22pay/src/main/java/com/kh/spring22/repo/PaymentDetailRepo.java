package com.kh.spring22.repo;

import com.kh.spring22.dto.PaymentDetailDto;

public interface PaymentDetailRepo {

	void save(PaymentDetailDto paymentDetailDto);
	void cancelPaymentDetail(int paymentNo);
	
	PaymentDetailDto find(int paymentDetailNo);
	void cancelPaymentDetailItem(int paymentDetailNo);
}
