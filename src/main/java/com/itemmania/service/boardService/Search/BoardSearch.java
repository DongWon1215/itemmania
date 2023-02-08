package com.itemmania.service.boardService.Search;

import com.itemmania.domain.search.BoardSearchOption;
import com.itemmania.domain.search.BoardSearchOptionVO;

import java.util.List;

public interface BoardSearch {/* 입력된 조건에 맞는 결과리스트 가져옴 (김주환)*/

    /*입력 조건의 맞는 프리미엄 리스트*/
    List<BoardSearchOptionVO> getP_SearchDataCheck(BoardSearchOption searchOption);

    /*입력 조건의 맞는 일반 리스트*/
    List<BoardSearchOptionVO> getSearchDataCheck(BoardSearchOption searchOption);


}
