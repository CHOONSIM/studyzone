package com.kh.springhome.dto;

import lombok.Data;

@Data
public class StudentDto {
	private int no;
	private String name;
	private int korean;
	private int english;
	private int math;
	
	public int getTotal() {
		return korean + english + math;
	}
	
	public int getAverage() {
		return (korean + english + math )/3;
	}
}
