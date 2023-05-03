package com.kh.spring22.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PaymentDto {

	private int paymentNo;
	private String paymentTid;
	private String paymentName;
	private int paymentTotal;
	private int paymentRemain;
	private Date paymentTime;
	private String memberId;
}
