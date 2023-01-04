package com.itemmania.entity;

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
    private int u_num;

    @Column
    private String u_name;

    @Column
    private String u_realName;

    @Column
    private String u_password;

    @Column
    private String u_phoneNumber;

    @Column
    private String u_eMail;

    @Column
    private long u_mileage;

    @Column
    private int u_creditScore;

    @Column
    private boolean u_isManager;

}
