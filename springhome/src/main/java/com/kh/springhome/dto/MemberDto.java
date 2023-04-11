package com.kh.springhome.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDto {
	public String memberId;
	public String memberPw;
	public String memberNick;
	public String memberTel;
	public String memberEmail;
	public String memberBirth;
	public String memberPost;
	public String memberBasicAddr;
	public String memberDetailAddr;
	public String memberLevel;
	public int memberPoint;
	public Date memberJoin;
	public Date memberLogin;
}


