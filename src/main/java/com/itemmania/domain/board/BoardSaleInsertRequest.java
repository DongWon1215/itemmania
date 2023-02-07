package com.itemmania.domain.board;

import com.itemmania.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardSaleInsertRequest {

    private String boardTitle;
    private int userNum;
    private int saleUnit;
    private int salePrice;
    private String serverName;
    private String saleNickName;
    private String saleAria;
    private boolean salePremium;

    public BoardEntity insertBoard() {
        return BoardEntity.builder()
                .boardTitle(boardTitle)
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
