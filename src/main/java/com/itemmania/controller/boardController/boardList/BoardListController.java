package com.itemmania.controller.boardController.boardList;


import com.itemmania.domain.BoardSearchOption;
import com.itemmania.domain.BoardSearchOptionVO;
import com.itemmania.entity.GameEntity;
import com.itemmania.entity.GameServerEntity;
import com.itemmania.service.boardService.Search.BoardGameSearch;
import com.itemmania.service.boardService.Search.BoardSearch;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@Controller
public class BoardListController {

    @Autowired
    private BoardSearch boardSearch;
    @Autowired
    private BoardGameSearch boardGameSearch;

    @PostMapping("/board/boardList")
    public String subsearch(Model model, BoardSearchOption boardSearchOption) {
        log.info("서브서치옵션" + boardSearchOption);

        boolean boardTradeStatus = boardSearchOption.isBoardTradeStatus();
        log.info("검색타입 " + boardTradeStatus);


        List<BoardSearchOptionVO> p_searchDataCheck = boardSearch.getP_SearchDataCheck(boardSearchOption);
        List<BoardSearchOptionVO> searchDataCheck = boardSearch.getSearchDataCheck(boardSearchOption);


 /*
        //기존 컨트롤러 model로 전송하였는데 모든페이지에서 사용하다보니 중복코드가 많아졌다
        //해결방안-> header가 화면에 로딩시 검색바만 부분 비동기처리하여 게임,서버리스트 출력하여 중복코드 제거(단일 책임 원칙)
        List<GameServerEntity> serverNameList = boardGameSearch.getServerService();
        List<GameEntity> gameNameList = boardGameSearch.getGameService();
        log.info("서브서치 컨트롤러 리스트 " + searchDataCheck);
        log.info("게임서버검색" + gameNameList);
        //프리미엄, 일반 리스트
        model.addAttribute("boarPList", p_searchDataCheck);
        model.addAttribute("boarList", searchDataCheck);
        // 전체 게임리스트
        model.addAttribute("searchGame", gameNameList);
        // 전체 서버리스트
        model.addAttribute("searchServer", serverNameList);
*/

        // 사용자가 검색한 게임서버 value
        model.addAttribute("searchGameServer", boardSearchOption.getSearchGameServer());

        // 검색당시 판매,구매인지
        model.addAttribute("searchType", boardSearchOption.getDeal());

        // 서브검색으로 선택된 신용등급
        model.addAttribute("userCreditScore", boardSearchOption.getUserCreditScore());

        //거래 상태 표시 value
        model.addAttribute("boardTradeStatus", boardTradeStatus);


        return "/board/boardList";

    }

}
