package com.itemmania.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "")
public class ItemEntity {

    @Id
    @Column
    @NotNull
    private int itemNum;

    @NotNull
    @Column
    private String itemName;

    @NotNull
    @Column
    private int itemPrice;
}
