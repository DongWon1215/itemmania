package com.itemmania.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardSearchOptionVO {

    //  게시판 번호
    private int board_num;

    // 회원 번호
    private int user_num;

    // 게임 이름
    private String game_name;

    // 서버 이름
    private String game_server_name;

    // 서버 번호
    private int server_num;

    // 거래 번호
    private int trade_num;

    // 게시글 작성 시간
    private Date board_time;

    // 게시판 제목, 물품 제목
    private String board_title;

    // 물건 수량
    private int sale_unit;

    // 판매 금액
    private int sale_price;

    // 거래하는 본인 캐릭터 명
    private String sale_nick_name;

    // 게시판 상세 -> 상세설명
    private String sale_aria;

    // 게시판 상세 -> 판매 스크린샷 (최대5장)
    private String sale_photo;

    // 판매 물품 수량  타입 (일반[value:0], 분할[value:1])
    private boolean sale_type;

    // 거래 현황  (진행중 [value:0], 거래완료 [value:1])
    private boolean board_trade_status;

    // 프리미엄 서비스 우뮤
    private boolean sale_premium;

    // 거래 완료 시간
    private Date deal_end_time;

    // board테이블 판매글 구매글 구분 (구매 : sale, 판매 : buy)
    private String deal_check;


}
