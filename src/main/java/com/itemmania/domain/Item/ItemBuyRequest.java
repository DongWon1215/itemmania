package com.itemmania.domain.Item;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ItemBuyRequest {

    private int itemNum;
    private int itemSerialNum;
}
