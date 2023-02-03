package com.itemmania.service.boardService.Search;


import com.itemmania.entity.GameEntity;
import com.itemmania.entity.GameServerEntity;
import com.itemmania.repository.GameEntityRepository;
import com.itemmania.repository.GameServerEntityRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BoardGameSearchService implements BoardGameSearch { //김주환
    @Autowired
    private GameServerEntityRepository gameServerEntityRepository;

    @Autowired
    private GameEntityRepository gameEntityRepository;

    //게임 리스트
    public List<GameEntity> getGameService() {
        List<GameEntity> gameName = gameEntityRepository.findAllBy();
        log.info("게임검색서비스" + gameName);
        return gameName;
    }

    //서버 리스트
    public List<GameServerEntity> getServerService() {
        List<GameServerEntity> servarName = gameServerEntityRepository.findAllBy();
        log.info("서버검색서비스" + servarName);
        return servarName;

    }
}
