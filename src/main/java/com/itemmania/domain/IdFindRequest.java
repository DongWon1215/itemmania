package com.itemmania.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class IdFindRequest {

    private String userName;
    private LocalDate userBirth;
    private String userPhoneNumber;
}
