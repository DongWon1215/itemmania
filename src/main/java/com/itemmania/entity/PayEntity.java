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
public class PayEntity {
    @Id
    @Column
    @NotNull
    private  int payNum;

    @Column
    @NotNull
    private  int userNum;

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
    private  boolean payIsSuccess;

    @Column
    @NotNull
    private LocalDate payTime;
}
