package com.kh.spring21.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

// 채널을 가진 웹소켓 서버에서 사용하는 메세지 수신 양식
// type = 1 일 경우 채팅 메세지로 간주하면 content 항목이 필요
// type = 2 일 경우 입장 메세지로 간주하며 room 항목이 필요

@Data
@JsonIgnoreProperties
public class ChannelReceiveVO {
	
	private int type;
	
//	@JsonIgnore // 이 필드는 없다고 생각해라(jackson에게 알려줌)
	private String content;
//	@JsonIgnore // 이 필드는 없다고 생각해라(jackson에게 알려줌)
	private String room;

}
