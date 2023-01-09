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
@Table(name = "buy")
public class BuyEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyNum;

    @ManyToOne
    @JoinColumn(name = "userNum")
    private UserEntity userNum;

    @ManyToOne
    @JoinColumn(name = "itemNum")
    private ItemEntity itemNum;

    @Column
    private int itemUnit;

    @Column
    private int price;

    @Column
    @NotNull
    private LocalDate time;
}
