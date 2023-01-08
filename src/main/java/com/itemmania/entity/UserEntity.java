package com.itemmania.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "user_email")
    @NotNull
    private String userEMail;

    @Column
    private int userMileage;

    @Column
    private int userCreditScore;

    @Column
    private boolean userIsManager;

    @Column
    private int itemUnit;

    @ManyToOne
    @JoinColumn(name = "itemNum", referencedColumnName = "itemName")
    private ItemEntity itemNum;


}
