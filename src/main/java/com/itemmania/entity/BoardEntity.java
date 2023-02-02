package com.itemmania.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "board")
public class BoardEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  게시판 번호
    private int boardNum;

    @ManyToOne
    @JoinColumn(name = "userNum")
    // 회원 번호
    private UserEntity userNum;

/*    @ManyToOne
    @NonNull
    @JoinColumn(name = "gameNum")
    // 게임 번호
    private GameEntity gameNum;*/
    // 기존 gameNum 삭제처리
    // serverNum을 통하여 gameserver테이블 Join 후 gameNum 부르고 return list<GameEntity>로 게임가져오기 

    @ManyToOne
    @JoinColumn(name = "serverNum")
    // 서버 번호
    private GameServerEntity serverNum;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // 게시글 작성 시간
    private LocalDateTime boardTime;

    @Column
    // 게시판 제목, 물품 제목
    private String boardTitle;

    @Column
    @ColumnDefault("0")
    // 물건 수량
    private int saleUnit;

    @Column
    @ColumnDefault("0")
    // 판매 금액
    private int salePrice;

    @Column
    // 거래하는 본인 캐릭터 명
    private String saleNickName;

    @Column
    // 게시판 상세 -> 상세설명
    private String saleAria;

    @Column
    // 게시판 상세 -> 판매 스크린샷 (최대5장)
    private String salePhoto;

    @Column
    @ColumnDefault("0")
    // 판매 물품 수량  타입 (일반[value:0], 분할[value:1])
    private boolean saleType;

    @Column
    @ColumnDefault("0")
    // 거래 현황  (진행중 [value:0], 거래완료 [value:1], 거래중 [value:2] )
    private int boardTradeStatus;

    @Column
    // 프리미엄 서비스 우뮤
    private boolean salePremium;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    // 거래 완료 시간
    private LocalDateTime dealEndTime;

    @Column
    // board테이블 판매글 구매글 구분 (구매 : sale, 판매 : buy)
    private String dealCheck;
}
