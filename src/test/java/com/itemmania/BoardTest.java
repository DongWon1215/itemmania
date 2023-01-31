package com.itemmania;

import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.GameEntity;
import com.itemmania.entity.GameServerEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Log4j2
@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void saveBoardTest(){

        BoardEntity insertBoard = BoardEntity.builder()
                .userNum(UserEntity.builder()
                        .userNum(4)
                        .userName("10")
                        .userRealName("함다빈10")
                        .userPassword(encoder.encode("10"))
                        .userPhoneNumber("10")
                        .userEmail("10")
                        .userBirth(LocalDate.ofEpochDay(20230107))
                        .build())
                .boardTitle("테스트 10101010")
                .serverNum(GameServerEntity.builder()
                        .serverNum(8).build())
                .boardTime(LocalDateTime.now())
                .saleUnit(10)
                .salePrice(100)
                .saleNickName("뚜어10")
                .saleAria("상세설명팝니다아10")
                .saleType(false)
                .salePremium(false)
                .dealCheck("buy")
                .salePhoto("")
                .build();


        BoardEntity saveBoard = boardRepository.save(insertBoard);

        log.info(saveBoard);
    }


}
