package com.itemmania.trade;

import com.itemmania.entity.BoardEntity;
import com.itemmania.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class 보드값상태변경Test {


    @Autowired
    BoardRepository boardRepository;

    @Test
    public void setboardNum() {

        log.info(boardRepository.findById(10));

        //보드 상태 0->2 로 변경
        boardRepository.updateBoardTradeStatusByBoardNum(2,10);

        /*return boardRepository.updateBoardTradeStatusByBoardNum();*/



    }
}
