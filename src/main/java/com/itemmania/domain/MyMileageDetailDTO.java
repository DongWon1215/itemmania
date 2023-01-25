package com.itemmania.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyMileageDetailDTO {

    private Integer amount;
    private LocalDate time;
    private Boolean plus;
    private String description;

}
