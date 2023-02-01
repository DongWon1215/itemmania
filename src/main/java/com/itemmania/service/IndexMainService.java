package com.itemmania.service;

import com.itemmania.entity.GameEntity;
import com.itemmania.entity.GameServerEntity;
import com.itemmania.repository.GameEntityRepository;
import com.itemmania.repository.GameServerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class IndexMainService {

    @Autowired
    private GameEntityRepository gameEntityRepository;


    // 메인화면 게임리스트 출력
    public List<GameEntity> getGameServer(){
        return gameEntityRepository.findAllBy();
    }

}

