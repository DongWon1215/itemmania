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
public class BuyEntity {
    @Id
    @Column
    @NotNull
    private int buyNum;

    @Column
    @NotNull
    private String userNum;

    @Column
    @NotNull
    private int itemNum;

    @Column
    private int itemUnit;

    @Column
    private int price;

    @Column
    @NotNull
    private LocalDate time;
}
