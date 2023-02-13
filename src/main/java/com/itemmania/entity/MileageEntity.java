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
@Table(name = "mileage")
public class MileageEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mileageNum;

    @ManyToOne
    @JoinColumn(name = "userNum")
    private UserEntity userNum;

    @Column
    @NotNull
    private LocalDateTime mileageTime;

    @Column
    @NotNull
    private String mileageType;

    @Column
    private String mileageDescription;

    @Column
    @ColumnDefault("0")
    private Integer mileageIn;

    @Column
    @ColumnDefault("0")
    private Integer mileageOut;


}
