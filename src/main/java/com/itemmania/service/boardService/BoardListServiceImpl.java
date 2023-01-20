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

    public List<BoardEntity> getDealCheckPremiumList(String DealCheck, boolean yes) {
        // boardList_Premium 출력
        List<BoardEntity> getboardList_P = boardRepository.boardListPremium(DealCheck, yes);
        log.info("보드 리스트 프리미엄 값" + getboardList_P);
        return getboardList_P;
    }

    public List<BoardEntity> getDealCheckList(String DealCheck, boolean no) {
        // boardList 출력
        List<BoardEntity> getboardList = boardRepository.boardListNotPremium(DealCheck, no);
        log.info("보드 리스트 프리미엄아닌 값" + getboardList);
        return getboardList;
    }


}
