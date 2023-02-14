package com.itemmania.controller.boardController.insert;


import com.itemmania.domain.ItemCountRequest;
import com.itemmania.domain.board.BoardSaleInsertRequest;
import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.ItemEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.BoardRepository;
import com.itemmania.repository.ItemRepository;
import com.itemmania.service.boardService.BoardInsertService;
import com.itemmania.service.boardService.Search.BoardGameSearchService;
import com.itemmania.service.useService.UseItemService;
import com.itemmania.service.userService.UserService;
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

    @Autowired
    private BoardInsertService boardInsertService;

    @Autowired
    private UserService userService;

    @Autowired
    private BoardGameSearchService gameSearchService;

    @Autowired
    private UseItemService useItemService;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public String getBoard(
            Model model,
            HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("userInfo");

        ItemCountRequest itemCountRequest = new ItemCountRequest(user.getUserNum(),1);

        model.addAttribute("userInfo",user);
        model.addAttribute("searchGame", getGameServerService.getGameService());
        model.addAttribute("searchServer", getGameServerService.getServerService());
        model.addAttribute("itemNum", useItemService.getItemCount(itemCountRequest));

        return "board/insert/boardSaleInsert";
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
    public JSONObject insertBoard(@RequestBody BoardSaleInsertRequest boardSaleInsertRequest, HttpServletRequest request)
    {

        BoardEntity board = boardSaleInsertRequest.insertBoard();

        board.setUserNum(userService.findUserByuserNum(boardSaleInsertRequest.getUserNum()).get());
        board.setServerNum(gameSearchService.getServerEntity(boardSaleInsertRequest.getServerName()));

        if(boardSaleInsertRequest.getUsingItemNum() != 0)
        {
            HttpSession session = request.getSession();
            UserEntity user = (UserEntity) session.getAttribute("userInfo");

            ItemEntity item = itemRepository.getReferenceById(1);

            useItemService.use(boardSaleInsertRequest.getUsingItemNum(),user,item);
            board.setSalePremium(true);
        }

        boardInsertService.insertBoard(board);
        JSONObject json = new JSONObject();
        json.put("board",board);

        return json;
    }

}