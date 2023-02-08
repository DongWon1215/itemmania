package com.itemmania.domain.mileage;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyMileageDetailRequest {

    private int userNum;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
