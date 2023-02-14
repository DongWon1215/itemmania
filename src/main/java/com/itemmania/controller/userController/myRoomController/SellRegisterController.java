package com.itemmania.controller.userController.myRoomController;

import com.itemmania.entity.TradeEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.boardService.BoardInNameOutnumService;
import com.itemmania.service.tradeService.detailsTrade.TradeSellerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/myroom/sellRegister")
public class SellRegisterController {

    @Autowired
    private TradeSellerService tradeSellerService;


/*
    @Autowired(required = false)
    private BoardInNameOutnumService boardInNameOutnumService;
*/


    @GetMapping
    public String getMypageForm(Model model, Principal principal) {

        log.info("Principal?" + principal.getName());

        /*   UserEntity userNum = boardInNameOutnumService.getUserNum(principal.getName());*/
     /*   log.info(userNum);
        List<TradeEntity> tradeSeller = tradeSellerService.getTradeSeller(userNum);
*/

        List<TradeEntity> tradeSeller = tradeSellerService.getTradeSeller();
        log.info("tradeSeller?" + tradeSeller);
        model.addAttribute("tradeSeller", tradeSeller);


        return "UserForm/myRoom/trade/sellRegister";
    }


}
