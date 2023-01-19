package com.itemmania.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameNum;

    @Column(unique = true)
    @NotNull
    private String gameName;

    @Column
    private String gameCurrency;

}
