package com.itemmania.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "")
public class BoardEntity {
    @Id
    @Column
    private int b_num;

    @Column
    @JoinColumn(name = UserEntity)
    @ManyToOne
    private int u_num;

    @Column
    private String b_title;

    @Column
    private String g_name;

    @Column
    private String g_server;

    @Column
    private int g_time;

    @Column
    private boolean s_type;

    @Column
    private int s_unit;

    @Column
    private long s_price;

    @Column
    private String s_nickName;

    @Column
    private String s_aria;

    @Column
    private String s_photo;

    @Column
    private boolean trade_status;

    @Column
    private boolean s_premium;
}
