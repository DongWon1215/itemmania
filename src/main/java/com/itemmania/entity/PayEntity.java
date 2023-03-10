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
@ToString
@Builder
@Entity
@Table(name = "pay")
public class PayEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int payNum;

    @ManyToOne
    @JoinColumn(name = "mileageNum")
    private  MileageEntity mileageNum;

    @Column
    @NotNull
    private  String payPg;

    @Column
    @NotNull
    private  String payPayment;

    @Column
    @ColumnDefault("0")
    private  int  payAmount;

    @Column
    @NotNull
    private LocalDateTime payTime;
}
