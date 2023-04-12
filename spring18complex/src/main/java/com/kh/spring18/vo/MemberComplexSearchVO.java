package com.kh.spring18.vo;

import java.util.List;

import lombok.Data;

// 회원 복합 검색용 VO
@Data
public class MemberComplexSearchVO {
	private String memberId;
	private String memberNick;
	private String memberEmail;
	private String memberBirth;
	private String memberTel;
	private String memberAddress;
	private List<String> memberLevelList;
	private Integer minPoint;
	private Integer maxPoint;
	private String beginJoinDate;
	private String endJoinDate;
	private Integer searchLoginDays;
}
