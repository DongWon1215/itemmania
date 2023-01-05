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
    private int u_num;

    @Column
    @NotNull
    private String u_name;

    @Column
    @NotNull
    private String u_realName;

    @Column
    @NotNull
    private String u_password;

    @Column
    @NotNull
    private String u_phoneNumber;

    @Column
    @NotNull
    private String u_eMail;

    @Column
    private long u_mileage;

    @Column
    private int u_creditScore;

    @Column
    private boolean u_isManager;

}
