package com.itemmania.domain.board;

import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.GameServerEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.boardService.Search.BoardGameSearchService;
import com.itemmania.service.userService.UserService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardBuyInsertRequest {

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
