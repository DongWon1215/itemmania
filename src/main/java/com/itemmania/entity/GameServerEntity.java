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
@Table(name = "gameServer")
public class GameServerEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serverNum;

    @ManyToOne
    @JoinColumn(name = "gameNum")
    private GameEntity gameNum;

    @Column(unique = true)
    private String gameServerName;

}
