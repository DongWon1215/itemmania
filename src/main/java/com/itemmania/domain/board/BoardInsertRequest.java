package com.itemmania.domain.board;


import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.GameServerEntity;
import com.itemmania.entity.UserEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardInsertRequest {

    // 등록할 데이터 (자동생성 제외)

    private String boardTitle;
    private UserEntity userNum;
    private int saleUnit;
    private int salePrice;
    private GameServerEntity serverNum;
    private String saleNickName;
    private String saleAria;
    private boolean saleType;
    private boolean salePremium;

    private MultipartFile salePhoto;
    private boolean boardTradeStatus;
    private LocalDateTime dealEndTime;
    private LocalDateTime boardTime;
    private String dealCheck;

    public BoardEntity insertBoard() {
        return BoardEntity.builder()
                .userNum(UserEntity.builder()
                        .userNum(userNum.getUserNum())
                        .build())
                .boardTitle(boardTitle)
                .serverNum(GameServerEntity.builder()
                        .serverNum(serverNum.getServerNum()).build())
                .boardTime(LocalDateTime.now())
                .saleUnit(saleUnit)
                .salePrice(salePrice)
                .saleNickName(saleNickName)
                .saleAria(saleAria)
                .saleType(saleType)
                .salePremium(salePremium)
                .dealCheck(dealCheck)
                .build();
    }
    private GameServerEntity getServerNum(int serverNum) {
        return GameServerEntity.builder()
                .serverNum(serverNum)
                .build();
    }


}

/*
    INSERT INTO `proj`.`board` (
        `board_time`, `board_title`, `board_trade_status`, `deal_check`,`game_num`,`server_num`, `sale_aria`, `sale_nick_name`,
        `sale_photo`, `sale_premium`,`sale_price`, `sale_type`, `sale_unit`, `user_num`)
        VALUES ( '2023-01-27', 'sale 일반 db입력 게임등록311',0, 'sale','3','11','상세설명', '본인닉네임', '등록사진', 0, '999',  0,'1','1');
*/