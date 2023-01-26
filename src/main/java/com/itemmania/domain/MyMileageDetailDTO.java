package com.itemmania.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyMileageDetailDTO {

    private Integer amount;
    private LocalDateTime time;
    private Boolean plus;
    private String description;

}
