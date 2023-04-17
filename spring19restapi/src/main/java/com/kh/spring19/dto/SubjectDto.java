package com.kh.spring19.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class SubjectDto {

	@Parameter(description = "강의번호",example="1",required=true)
	private int no;
	@Parameter(description = "강의이름",example="테스트",required = true)
	private String name;
	@Parameter(description = "수강기간",example = "30",required = true)
	private int period;
	@Parameter(description = "수강료", example = "100000", required = true)
	private int price;
	@Parameter(description = "강의유형",example = "오프라인", required = true)
	private String type;
	
}
