package com.itemmania.controller.boardController.insert;


import com.itemmania.domain.board.BoardSaleInsertRequest;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.boardService.BoardInsertService;
import com.itemmania.service.boardService.Search.BoardGameSearchService;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequestMapping("/board/sale/insert")
public class BoardSaleInsertController {

    @Autowired
    private BoardGameSearchService getGameServerService;

    @GetMapping
    public String getBoard(
            Model model,
            HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        model.addAttribute("userInfo",user);
        model.addAttribute("searchGame", getGameServerService.getGameService());
        model.addAttribute("searchServer", getGameServerService.getServerService());
        return "/board/insert/boardSaleInsert";
    }

/*    @PostMapping
    public String getInsertForm(
            BoardInsertRequest boardInsertRequest
    ){

        log.info(">>>>>>>>>>>" + boardInsertRequest);
        String absolutePath = new File("").getAbsolutePath();
        log.info(">>> path : " + absolutePath);


        return "redirect:/board/boardList";
    }*/

    @PostMapping
    @ResponseBody
    public JSONObject insertBoard(@RequestBody BoardSaleInsertRequest boardSaleInsertRequest)
    {

        JSONObject json = new JSONObject();


        return json;
    }

}