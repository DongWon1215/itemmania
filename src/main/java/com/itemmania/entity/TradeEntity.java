package com.itemmania.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "")
public class TradeEntity {
    @Id
    @Column
    @NotNull
    private int tradeNum;

    @Column
    @NotNull
    private int consumerNum;

    @Column
    @NotNull
    private int sellerNum;

    @Column
    @NotNull
    private int boardNum;

    @Column
    private int tradeAmount;

    @Column
    private int tradeUnit;

    @Column
    @NotNull
    private boolean tradeIsSuccess;

    @Column
    @NotNull
    private LocalDate tradeTime;
}
