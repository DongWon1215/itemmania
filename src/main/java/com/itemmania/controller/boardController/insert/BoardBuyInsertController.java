package com.itemmania.controller.boardController.insert;


import com.itemmania.domain.ItemCountRequest;
import com.itemmania.domain.board.BoardBuyInsertRequest;
import com.itemmania.domain.board.BoardInsertRequest;
import com.itemmania.entity.*;
import com.itemmania.repository.BoardRepository;
import com.itemmania.repository.ItemRepository;
import com.itemmania.service.boardService.BoardInsertService;
import com.itemmania.service.boardService.BoardViewService;
import com.itemmania.service.boardService.Search.BoardGameSearchService;
import com.itemmania.service.boardService.Search.BoardSearchService;
import com.itemmania.service.useService.UseItemService;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board/buy/insert")
public class BoardBuyInsertController {

    @Autowired
    private BoardInsertService boardInsertService;

    @Autowired
    private BoardGameSearchService getGameServerService;

    @Autowired
    private UserService userService;

    @Autowired
    private BoardGameSearchService gameSearchService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UseItemService useItemService;

    @GetMapping
    public String getInsetBoard(
            Model model,
            HttpServletRequest request
            ){

        HttpSession session = request.getSession();
        log.info("request>>>>>>>>>>>>>>>>>>>>>>>>."+request);
        log.info("board Insert Controller" + session.getAttribute("userInfo"));
        List<GameServerEntity> serverNameList = getGameServerService.getServerService();

        List<GameEntity> gameNameList = getGameServerService.getGameService();
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        ItemCountRequest itemCountRequest = new ItemCountRequest(user.getUserNum(),1);
        model.addAttribute("myInfo",user);
        // 전체 게임리스트
        model.addAttribute("searchGame", gameNameList);

        // 전체 서버리스트
        model.addAttribute("searchServer", serverNameList);

        model.addAttribute("itemNum", useItemService.getItemCount(itemCountRequest));

        return "board/insert/boardBuyInsert";
    }


    @PostMapping
    @ResponseBody
    public JSONObject getInsertForm(
                @RequestBody BoardBuyInsertRequest boardInsertRequest, HttpServletRequest request
    ){

        log.info(">>>>>>>>>>>" + boardInsertRequest);

        BoardEntity board = boardInsertRequest.insertBoard();
        board.setUserNum(userService.findUserByuserNum(boardInsertRequest.getUserNum()).get());
        board.setServerNum(gameSearchService.getServerEntity(boardInsertRequest.getServerName()));

        log.info("board info =============>" + board);

//        String absolutePath = new File("").getAbsolutePath();
//        log.info(">>> path : " + absolutePath);

        if(boardInsertRequest.getUsingItemNum() != 0)
        {
            HttpSession session = request.getSession();
            UserEntity user = (UserEntity) session.getAttribute("userInfo");

            ItemEntity item = itemRepository.getReferenceById(1);

            useItemService.use(boardInsertRequest.getUsingItemNum(),user,item);
            board.setSalePremium(true);
        }

        JSONObject json = new JSONObject();
        boardInsertService.insertBoard(board);
        json.put("board",board);

        return json;
    }
}