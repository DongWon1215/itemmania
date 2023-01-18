package com.itemmania.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myroom/trnsc_hstry")
public class MyTrasactionHistortyController {


    @GetMapping
    public String getMyTrnscHstry()
    {
        return "userForm/myRoom/trade/myTransactionHistory";
    }


}
