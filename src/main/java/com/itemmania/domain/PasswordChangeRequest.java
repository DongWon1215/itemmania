package com.itemmania.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PasswordChangeRequest {

    private String userRealName;
    private LocalDate userBirth;
    private String userName;
    private String userEmail;
    private String userPassword;

}
