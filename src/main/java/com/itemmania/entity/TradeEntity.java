package com.itemmania.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trade")
public class TradeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tradeNum;

    @ManyToOne
    @JoinColumn(name = "consumerMileage")
    private MileageEntity consumerMileage;

    @ManyToOne
    @JoinColumn(name = "sellerMileage")
    private MileageEntity sellerMileage;

    @ManyToOne
    @JoinColumn(name = "boardNum")
    private BoardEntity boardNum;

    @Column
    @ColumnDefault("0")
    private int tradeAmount;

    @Column
    @ColumnDefault("0")
    private int tradeUnit;

    @Column
    private boolean tradeIsSuccess;

    @Column
    @NotNull
    private LocalDateTime tradeTime;
}
