package com.itemmania.service.boardService.Search;

import com.itemmania.entity.BoardEntity;
import com.itemmania.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.javassist.compiler.ast.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class BoardSearchService {

    @Autowired
    private BoardRepository boardRepository;

    //삽니다, 팝니다 구분하여 사용자가 입력한 게임or게임서버를 검색후 프리미엄 결과값만 출력 
    public List<BoardEntity> getP_SearchDataCheck(String dealCheck, String gameName, String gameServerName) {
        int premium = 1;
        log.info(premium+ dealCheck + gameName + gameServerName);

        List<BoardEntity> P_list = boardRepository.boardP_SearchList(premium, dealCheck, gameName, gameServerName);
        log.info("검색서비스_프리미엄" + P_list);
        return P_list;
    }

    //삽니다, 팝니다 구분하여 사용자가 입력한 게임or게임서버를 검색후 일반 결과값만 출력
    public List<BoardEntity> getSearchDataCheck(String dealCheck, String gameName, String gameServerName) {
        int premium = 0;
        log.info(premium+dealCheck + gameName + gameServerName);

        List<BoardEntity> list = boardRepository.boardSearchList(premium, dealCheck, gameName, gameServerName);
        log.info("검색서비스_일반" + list);
        return list;
    }
}
