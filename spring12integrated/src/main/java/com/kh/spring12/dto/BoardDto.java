package com.kh.spring12.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDto {
	public int boardNo;
	public String boardWriter;
	public String boardTitle;
	public String boardContent;
	public Date boardTime;
	public String boardHead;
	public int boardRead;
	public int boardLike;
	public int boardReply;
}
