package com.itemmania.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "")
public class BoardEntity {
    @Id
    @Column
    private int boardNum;

    @Column
    private int userNum;

    @Column
    private int gameNum;

    @Column
    private String gameServer;

    @Column
    private LocalDate boardTime;

    @Column
    private String boardTitle;

    @Column
    private int saleUnit;

    @Column
    private int salePrice;

    @Column
    private String saleNickName;

    @Column
    private String saleAria;

    @Column
    private String salePhoto;

    @Column
    private boolean saleType;

    @Column
    private boolean boardTradeStatus;

    @Column
    private boolean salePremium;
}
