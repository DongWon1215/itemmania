package com.itemmania.controller.boardController.insert;


import com.itemmania.domain.board.BoardInsertRequest;
import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.boardService.BoardInsertService;
import com.itemmania.service.boardService.BoardViewService;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@Log4j2
@RequestMapping("/board/buy/insert")
public class BoardBuyInsertController {

    @Autowired
    private BoardInsertService boardInsertService;
    @Autowired
    private BoardViewService boardViewService;



    @GetMapping
    public String getInsetBoard(
            Model model,
            HttpServletRequest request
//            int userNum
            ){
        log.info("board test 진행중... ");
        model.addAttribute("gameSrever",boardInsertService.getGameServer());

        HttpSession session = request.getSession();
        log.info("request>>>>>>>>>>>>>>>>>>>>>>>>."+request);
        log.info("board Insert Controller" + session.getAttribute("userInfo"));

        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        int userNum = user.getUserNum();
        model.addAttribute("myInfo",boardInsertService.selectMyInfo(userNum));

/*
        model.addAttribute("myInfo",boardInsertService.selectMyInfo(2));
*/

        return "/board/insert/boardBuyInsert";
    }


    @PostMapping
    public String getInsertForm(
            BoardInsertRequest boardInsertRequest
    ){

        log.info(">>>>>>>>>>>" + boardInsertRequest);
        String absolutePath = new File("").getAbsolutePath();
        log.info(">>> path : " + absolutePath);

        return "redirect:/board/boardList";
    }
    public BoardEntity insertBoard (@RequestBody BoardEntity boardEntity){

        log.info("insert 전 "+boardEntity);
        /// Service -> Mapper
        boardInsertService.insertBoard(boardEntity);

        log.info("insert 후 "+boardEntity);

        boardEntity.setBoardTime(LocalDateTime.parse(LocalDateTime.now().toString()));

        ResponseEntity<BoardEntity> boardEntityResponseEntity = new ResponseEntity<>(boardViewService.selectBoardView(boardEntity.getBoardNum()), HttpStatus.OK);
        log.info("board등록성공? >>>>>>>>." + boardEntityResponseEntity);
        return boardEntityResponseEntity.getBody();
    }

}