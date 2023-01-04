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
    private int userIndex;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @Column
    private String eMail;

    @Column
    private long mileage;

    @Column
    private int creditScore;

    @Column
    private boolean isManager;

}
