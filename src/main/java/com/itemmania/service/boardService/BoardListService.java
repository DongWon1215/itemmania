package com.itemmania.service.boardService;

import com.itemmania.entity.BoardEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BoardListService {

    //모든 리스트 출력
    /*List<BoardEntity> getAllList();*/

    //구매,판매 리스트 출력
    List<BoardEntity> getDealCheckList(String DealCheck);


}
