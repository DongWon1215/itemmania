package com.itemmania.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class KakaoDTO {

    private String profile_nickname;
    private String account_email;
    private String birthday;
}
