package com.itemmania.controller.userController.myRoomController;

import com.itemmania.entity.TradeEntity;
import com.itemmania.service.tradeService.detailsTrade.GetBuyListService;
import com.itemmania.service.tradeService.detailsTrade.TradeSellerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Log4j2
@Controller
public class BuyRegisterController {
    @Autowired
    private TradeSellerService tradeSellerService;

    @Autowired
    private GetBuyListService getBuyListService;

    @GetMapping("/myroom/buyRegister")
    public String getMypageForm(Model model) {

        List<TradeEntity> tradeSeller = tradeSellerService.getTradeSeller();



        log.info("tradeSeller?" + tradeSeller);
        model.addAttribute("tradeSeller", tradeSeller);
        return "UserForm/myRoom/trade/buyRegister";
    }

    @GetMapping("getBuyList")
    @ResponseBody
    public List<TradeEntity> getBuyHistory(int userNum){
        return getBuyListService.getList(userNum);
    }


}
