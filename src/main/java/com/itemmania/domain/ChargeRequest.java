package com.itemmania.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChargeRequest {

    private int userNum;
    private String pg;
    private String payment;
    private int payAmount;

}
