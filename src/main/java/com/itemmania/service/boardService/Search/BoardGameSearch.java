package com.itemmania.service.boardService.Search;


import com.itemmania.entity.GameEntity;
import com.itemmania.entity.GameServerEntity;

import java.util.List;

public interface BoardGameSearch {   /*게임,서버 리스트 (김주환)*/

    
    
    /*GameEntity에서 게임리스트를 모두 가져옴*/
    List<GameEntity> getGameService();

    /*GameServerEntity에서 서버리스트를 모두 가져옴*/
    List<GameServerEntity> getServerService();
}