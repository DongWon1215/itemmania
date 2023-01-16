package com.itemmania.service.boardService;

import com.itemmania.entity.BoardEntity;
import com.itemmania.repository.BoardRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
public class BoardListService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardEntity> getList() {
//       log.info("BoardListService 들어옴");
        List<BoardEntity> all = boardRepository.findAll();
//        log.info("BoardListService 탈출");
        return all;
    }


}
