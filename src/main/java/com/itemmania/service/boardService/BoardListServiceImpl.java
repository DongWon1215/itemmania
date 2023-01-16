package com.itemmania.service.boardService;

import com.itemmania.entity.BoardEntity;
import com.itemmania.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BoardListServiceImpl implements BoardListService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardEntity> getAllList() {
        // 모두 출력
        log.info("BoardListService 들어옴");
        List<BoardEntity> getAllList = boardRepository.findAll();
        log.info(getAllList + "겟올리스트");
        log.info("BoardListService 탈출");
        return getAllList;
    }

    public List<BoardEntity> getDealCheckList(String DealCheck) {
        // sale 출력
        log.info("BoardListService 들어옴");

        List<BoardEntity> getsaleList = boardRepository.findByDealCheck(DealCheck);
        log.info("BoardListService 탈출");
        return getsaleList;
    }


}
