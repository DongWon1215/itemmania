package com.itemmania.entity;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trade")
public class TradeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tradeNum;

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
    private Integer tradeAmount;

    @Column
    @ColumnDefault("0")
    private Integer tradeUnit;

    @Column
    @ColumnDefault("")
    private Boolean tradeIsSuccess;

    @Column
    private LocalDateTime tradeTime;

}
