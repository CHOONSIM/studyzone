package com.kh.spring19.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class StudentDto {
	
	@Parameter(description = "학생번호", example="1", required = true)
	private int no;
	@Parameter(description = "학생이름", example = "테스트", required = true)
	private String name;
	@Parameter(description = "국어점수", example = "10", required = true)
	private int korean;
	@Parameter(description = "영어점수", example = "10", required = true)
	private int english;
	@Parameter(description = "수학점수", example = "10", required = true)
	private int math;
	@Parameter(description = "총점수", example = "30", required = true)
	private int getTotal() {
		return korean + english + math;
	}
	@Parameter(description = "평균점수", example = "10", required = true)
	private int getAverage() {
		return (korean + english + math)/3;
	}
	
}
