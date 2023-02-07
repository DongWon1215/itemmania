package com.itemmania.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "itemUse")
public class UseEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int useNum;

    @ManyToOne
    @JoinColumn(name = "userNum")
    private UserEntity userNum;

    @ManyToOne
    @JoinColumn(name = "itemNum")
    private ItemEntity itemNum;

    @Column
    private int usedUnit;

    @Column
    private LocalDateTime usedTime;
}
