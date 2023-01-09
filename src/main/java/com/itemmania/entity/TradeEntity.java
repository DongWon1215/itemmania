package com.itemmania.entity;

import com.sun.istack.NotNull;
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
@Table(name = "trade")
public class TradeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tradeNum;

    @ManyToOne
    @JoinColumn(name = "userNum", insertable = false, updatable = false)
    private UserEntity consumerNum;

    @ManyToOne
    @JoinColumn(name = "userNum", insertable = false, updatable = false)
    private UserEntity sellerNum;

    @ManyToOne
    @JoinColumn(name = "boardNum")
    private BoardEntity boardNum;

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
