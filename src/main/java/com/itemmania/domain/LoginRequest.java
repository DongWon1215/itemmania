package com.itemmania.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LoginRequest {

    private String user_name;

    private String user_password;

    private String apiToken;
}
