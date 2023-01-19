package com.itemmania.domain;

import com.itemmania.entity.UserEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {

    private int userNum;
    private String userName;
    private String userPassword;
    private String userRealName;
    private String userEmail;
    private String userPhoneNum;
    private LocalDate userBirth;

    public UserEntity toUserEntity()
    {
        UserEntity user = new UserEntity(userBirth,userName,userPassword,userEmail,userRealName,userPhoneNum);

        return user;
    }
}
