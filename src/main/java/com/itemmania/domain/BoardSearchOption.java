package com.itemmania.domain;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class BoardSearchOption {
    // 판매 구매 구분
    private String deal;

    // 프리미엄 서비스 유무
    private boolean salePremium;


    // 판매중인지 거래완료인지 구분
    private boolean boardTradeStatus;


    // 사용자가 검색한 게임, 서버이름
    private String searchGameServer;
    // 페이지 번호
    private int p = 0;

    // 페이지 사이즈
    private int size = 5;



}
