package com.itemmania.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BuyRequestDTO {
    private int buyItemUnit;
    private int buyPrice;
    private LocalDateTime buyTime;
}
