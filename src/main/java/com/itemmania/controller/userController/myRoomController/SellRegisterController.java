package com.itemmania.controller.userController.myRoomController;

import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.TradeEntity;
import com.itemmania.service.tradeService.detailsTrade.TradeSellerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/myroom/sellRegister")
public class SellRegisterController {


    @Autowired
    TradeSellerService tradeSellerService;

    @GetMapping
    public String getMypageForm(Model model) {

        List<TradeEntity> tradeSeller = tradeSellerService.getTradeSeller();

        log.info("tradeSeller?"+tradeSeller);
        model.addAttribute("tradeSeller",tradeSeller);


        return "userForm/myRoom/trade/sellRegister";
    }


}
