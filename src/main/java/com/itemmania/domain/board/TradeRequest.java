package com.itemmania.domain.board;

import com.itemmania.entity.BoardEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TradeRequest {

    private int tradeNum;
    private BoardEntity boardNum;
}
