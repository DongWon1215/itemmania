package com.itemmania.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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

    @Column
    @ColumnDefault("'etc'")
    private String gameServerName;


    public String getGameNameDeduplication(GameServerEntity gameServerEntity) {
        return gameServerEntity.gameNum.getGameName();
    }

}
