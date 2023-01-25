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
@Table(name = "pay")
public class PayEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int payNum;

    @ManyToOne
    @JoinColumn(name = "userNum")
    private  UserEntity userNum;

    @Column
    @NotNull
    private  String payPg;

    @Column
    @NotNull
    private  String payPayment;

    @Column
    private  int  payAmount;

    @Column
    @NotNull
    private LocalDate payTime;
}
