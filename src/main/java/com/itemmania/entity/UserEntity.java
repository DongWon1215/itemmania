package com.itemmania.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "")
public class UserEntity {
    @Id
    @Column
    @NotNull
    private int userNum;

    @Column
    @NotNull
    private String userName;

    @Column
    @NotNull
    private String userRealName;

    @Column
    @NotNull
    private String userPassword;

    @Column
    @NotNull
    private String userPhoneNumber;

    @Column
    @NotNull
    private String userEMail;

    @Column
    private int userMileage;

    @Column
    private int userCreditScore;

    @Column
    private boolean userIsManager;

}
