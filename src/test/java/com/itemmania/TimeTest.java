package com.itemmania;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Log4j2
@SpringBootTest
public class TimeTest {

    @Test
    public void dateTimeTest(){
        LocalDateTime localDateTime = LocalDateTime.now();

        log.info(localDateTime + "@@@@@@@@@@@@@@@@@@@@@@");

        LocalDateTime testDateTime = LocalDateTime.of(1, 1, 1, 1, 1);

    }
}
