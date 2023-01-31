package com.itemmania.controller.boardController.boardList;


import com.itemmania.repository.GameServerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameSearch_frameController {

    @Autowired
    GameServerEntityRepository gameServerEntityRepository;

    @PostMapping("/board/baordlist/frame")

    public void gameSearch_frame() {
        gameServerEntityRepository.findAll();

    }

}
