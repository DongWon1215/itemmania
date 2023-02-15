package com.itemmania.service.tradeService;


import com.itemmania.entity.BoardEntity;
import com.itemmania.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class BoardStateChangeService {


    @Autowired
    BoardRepository boardRepository;

    /*board->boardTradeStatus 상태2로 변경*/
    public int boardStateChange(BoardEntity boardEntity) {
        log.info("get보드넘" + boardEntity);
        return boardRepository.updateBoardTradeStatusByBoardNum(2,boardEntity.getBoardNum());

    }

    public int boardTradeStateChange(int state, int boardNum)
    {
        return boardRepository.updateBoardTradeStatusByBoardNum(state,boardNum);
    }

}
