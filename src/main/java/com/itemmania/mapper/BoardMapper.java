package com.itemmania.mapper;

import com.itemmania.domain.search.BoardSearchOption;
import com.itemmania.domain.search.BoardSearchOptionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //메인 검색서치
    List<BoardSearchOptionVO> boardSearchList(BoardSearchOption searchOption, boolean salePremium);
}
