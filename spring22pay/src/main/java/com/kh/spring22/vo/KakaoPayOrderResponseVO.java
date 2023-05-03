package com.kh.spring22.vo;

import lombok.Data;

@Data
public class KakaoPayOrderResponseVO {

    private String tid; // 결제 고유 번호
    private String next_redirect_pc_url; // PC 결제를 위한 URL
    private String created_at; // 결제 준비 요청 시간
}
