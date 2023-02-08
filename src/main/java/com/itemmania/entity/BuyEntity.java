package com.itemmania.entity;

import com.itemmania.domain.BuyRequestDTO;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "buy")
public class BuyEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyNum;

    @ManyToOne
    @JoinColumn(name = "mileageNum")
    private MileageEntity mileageNum;

    @ManyToOne
    @JoinColumn(name = "itemNum")
    private ItemEntity itemNum;

    @Column
    @ColumnDefault("0")
    private int buyItemUnit;

    @Column
    @ColumnDefault("0")
    private int buyPrice;

    @Column
    @NotNull
    private LocalDateTime buyTime;

    public BuyRequestDTO to_DTO()
    {
        return new BuyRequestDTO(buyItemUnit,buyPrice,buyTime);


    }
}
