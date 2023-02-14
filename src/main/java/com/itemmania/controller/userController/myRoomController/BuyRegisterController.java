package com.itemmania.controller.userController.myRoomController;

import com.itemmania.entity.TradeEntity;
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
@RequestMapping("/myroom/buyRegister")
public class BuyRegisterController {


    @Autowired
    private TradeSellerService tradeSellerService;

    @GetMapping
    public String getMypageForm(Model model, Principal principal) {
//        log.info("Principal?" + principal.getName());

        List<TradeEntity> tradeSeller = tradeSellerService.getTradeSeller(principal.getName());
        log.info("tradeSeller?" + tradeSeller);

        model.addAttribute("tradeSeller", tradeSeller);



        return "UserForm/myRoom/trade/buyRegister";
    }


}
