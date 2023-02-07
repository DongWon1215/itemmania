package com.itemmania.service.boardService.Search;

import com.itemmania.domain.search.BoardSearchOption;
import com.itemmania.domain.search.BoardSearchOptionVO;
import com.itemmania.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BoardSearchService implements BoardSearch { //김주환

    @Autowired(required = false)
    private BoardMapper boardMapper;


    //삽니다, 팝니다 구분하여 사용자가 입력한 게임or게임서버를 검색후 프리미엄 결과값만 출력
    public List<BoardSearchOptionVO> getP_SearchDataCheck(BoardSearchOption searchOption) {
        log.info("프리미엄 서비스 ->" + searchOption);
        boolean salePremium = true;
        List<BoardSearchOptionVO> P_list = boardMapper.boardSearchList(searchOption, salePremium);
        log.info("검색서비스_프리미엄" + P_list);
        return P_list;
    }

    //삽니다, 팝니다 구분하여 사용자가 입력한 게임or게임서버를 검색후 일반 결과값만 출력
    public List<BoardSearchOptionVO> getSearchDataCheck(BoardSearchOption searchOption) {
        log.info("일반 서비스and 검색서치옵션 ->" + searchOption);
        boolean salePremium = false;

        List<BoardSearchOptionVO> list = boardMapper.boardSearchList(searchOption, salePremium);

        return list;
    }
}
/*

에이젝스 사용으로 만들었다가 getSearchDataCheck랑 중복코드가 많아서  getSearchDataCheck 사용하기로 함
    public List<BoardSearchOptionVO> getSearchDataCheck(BoardSearchOption searchOption) {
        log.info("서치서비스 검색옵션->" + searchOption);
        boolean salePremium = false;
        boolean boardTradeStatus = false;

        List<BoardSearchOptionVO> list = boardMapper.boardSearchList(searchOption , salePremium,boardTradeStatus);

        return list;
    }

*/
