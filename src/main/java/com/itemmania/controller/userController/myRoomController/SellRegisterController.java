package com.itemmania.controller.userController.myRoomController;

import com.itemmania.entity.MileageEntity;
import com.itemmania.entity.TradeEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.TradeRepository;
import com.itemmania.service.boardService.BoardInNameOutnumService;

import com.itemmania.service.tradeService.detailsTrade.GetSellListService;

import com.itemmania.service.tradeService.BoardStateChangeService;

import com.itemmania.service.tradeService.detailsTrade.TradeSellerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Log4j2
@Controller
public class SellRegisterController {

    @Autowired
    private TradeSellerService tradeSellerService;


    @Autowired
    private GetSellListService getSellListService;


    @GetMapping("myroom/sellRegister")
    public String getMypageForm(HttpServletRequest request, Model model) {

/*
        MileageEntity mileage1 = ;
        MileageEntity mileage1 = ;
*/

        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("userInfo");

        List<TradeEntity> tradeSeller = tradeSellerService.getTradeSeller();

        log.info("tradeSeller?" + tradeSeller);
        model.addAttribute("tradeSeller", tradeSeller);

        return "UserForm/myRoom/trade/sellRegister";
    }

    @GetMapping("getSellList")
    @ResponseBody
    public List<TradeEntity> getSellHistory(int userNum){
        return getSellListService.getList(userNum);
    }

}
