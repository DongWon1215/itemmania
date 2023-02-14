package com.itemmania.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;


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
    @JoinColumn(name = "consumerNum")
    private UserEntity consumerNum;
    /*
        필요없음  마일리지PK row가 구매자 PK보다적으면 오류
        @ManyToOne
        @JoinColumn(name = "sellerMileage")
        private MileageEntity sellerMileage;

    */
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
    private Boolean tradeIsSuccess;

    @Column
    private LocalDateTime tradeTime;

}
