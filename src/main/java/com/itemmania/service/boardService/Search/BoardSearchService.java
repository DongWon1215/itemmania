package com.itemmania.service.boardService.Search;

import com.itemmania.domain.BoardSearchOptionVO;
import com.itemmania.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BoardSearchService {
    @Autowired(required = false)
    private BoardMapper boardMapper;


    //삽니다, 팝니다 구분하여 사용자가 입력한 게임or게임서버를 검색후 프리미엄 결과값만 출력
    public List<BoardSearchOptionVO> getP_SearchDataCheck(int p, int size, String deal, String searchGameServer) {
        log.info("프리미엄 서비스 ->" + deal, searchGameServer);
        boolean salePremium = true;
        boolean boardTradeStatus = false;
        List<BoardSearchOptionVO> P_list = boardMapper.boardSearchList(salePremium, p,size,  deal, boardTradeStatus, searchGameServer);
        log.info("검색서비스_프리미엄" + P_list);
        return P_list;
    }

    //삽니다, 팝니다 구분하여 사용자가 입력한 게임or게임서버를 검색후 일반 결과값만 출력
    public List<BoardSearchOptionVO> getSearchDataCheck(int p, int size, String deal, String searchGameServer) {
        log.info("일반 서비스 ->" +  deal, searchGameServer);
        boolean salePremium = false;
        boolean boardTradeStatus = false;

        List<BoardSearchOptionVO> list = boardMapper.boardSearchList(salePremium, p, size, deal, boardTradeStatus, searchGameServer);

        return list;
    }
}
