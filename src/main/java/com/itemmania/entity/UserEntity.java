package com.itemmania.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

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
    @ColumnDefault("0")
    private int userMileage;

    @Column
    @ColumnDefault("0")
    private int userCreditScore;

    @Column
    @NotNull
    @ColumnDefault("0")
    private boolean userIsManager;

    @Column
    @ColumnDefault("0")
    private int itemUnit;

    @ManyToOne
    @JoinColumn(name = "itemNum")
    private ItemEntity itemNum;

    @Column
    @NotNull
    private LocalDate userBirth;

    public UserEntity(LocalDate userBirth, String userName, String userPassword, String userEMail, String userRealName, String userPhoneNumber)
    {
        this.userBirth = userBirth;
        this.userName = userName;
        this.userEmail = userEMail;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userRealName = userRealName;
    }
}
