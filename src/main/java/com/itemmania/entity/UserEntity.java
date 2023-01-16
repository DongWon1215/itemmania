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
@Table(name = "user")
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
    private String userEmail;

    @Column
    private int userMileage;

    @Column
    private int userCreditScore;

    @Column
    private boolean userIsManager;

    @Column
    private int itemUnit;

    @ManyToOne
    @JoinColumn(name = "itemNum")
    private ItemEntity itemNum;


}
