package com.kh.spring12.dto;

import lombok.Data;

@Data
public class MemberStatDto {
	private String memberLevel;
	private int cnt, total;
	private float avg;
	private int max,min;
}
