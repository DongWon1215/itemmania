package com.itemmania.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemCountRequest {

    private int userNum;
    private int itemNum;

}
