package com.itemmania.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyMileageDetailRequest {

    private int userNum;
    private LocalDate startDate;
    private LocalDate endDate;

}
