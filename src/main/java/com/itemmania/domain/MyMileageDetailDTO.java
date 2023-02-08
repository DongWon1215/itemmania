package com.itemmania.domain;

import com.itemmania.entity.MileageEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyMileageDetailDTO {

    private MileageEntity mileageEntity;
    private int mileageHistory;

}
