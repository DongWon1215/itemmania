package com.itemmania.domain.trade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class trade_insert_VO {

    // 구매 마일리지 내역
    private int consumer_mileage;

    //판매 마일리지 내역
    private int seller_mileage;

    // 거래 게시글 번호
    private int board_num;

    // 거래 금액 (거래 비정상 종료시 0)
    private int trade_amount;

    // 거래수량
    private int trade_unit;

    // 정상 종료 구분 (0:비정상 1:정상)
    private boolean trade_is_success;

    // 거래 종료 시간
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date tradeTime;


}
