package com.itemmania.domain;

import com.itemmania.entity.ItemEntity;
import com.itemmania.entity.UserEntity;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserModifyRequest {

    private int userNum;

    private String userPassword;

    private String userPhoneNumber;

    private String userEmail;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate userBirth;

    public UserEntity toUserEntity(){
        return UserEntity.builder().userPassword(userPassword).userPhoneNumber(userPhoneNumber).userEmail(userEmail).userBirth(userBirth).build();
    }

}


