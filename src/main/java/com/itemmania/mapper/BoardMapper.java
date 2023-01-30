package com.itemmania.mapper;

import com.itemmania.domain.BoardSearchOption;
import com.itemmania.domain.BoardSearchOptionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //메인 검색서치
    List<BoardSearchOptionVO> boardSearchList(boolean salePremium, int p, int size, String deal, boolean boardTradeStatus, String searchGameServer);

    List<BoardSearchOptionVO> boardSearchList(BoardSearchOption searchOption, boolean salePremium);
}
