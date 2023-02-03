package com.itemmania.domain.board;

import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.GameServerEntity;
import com.itemmania.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardBuyInsertRequest {

    private String boardTitle;
    private UserEntity userNum;
    private int saleUnit;
    private int salePrice;
    private GameServerEntity serverNum;
    private String saleNickName;
    private String saleAria;
    private boolean salePremium;

    public BoardEntity insertBoard() {
        return BoardEntity.builder()
                .userNum(userNum)
                .boardTitle(boardTitle)
                .serverNum(serverNum)
                .boardTime(LocalDateTime.now())
                .saleUnit(saleUnit)
                .salePrice(salePrice)
                .saleNickName(saleNickName)
                .saleAria(saleAria)
                .saleType(false)
                .salePremium(salePremium)
                .dealCheck("sale")
                .build();
    }
}
