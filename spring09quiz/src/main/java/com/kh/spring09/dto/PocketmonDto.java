package com.kh.spring09.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data							//setter, getter, toString(), equals(), hashCode() 생성
@NoArgsConstructor
//@AllArgsConstructor		//생성자 생성
public class PocketmonDto {
	private int no;
	private String name;
	private String type;
	
}
