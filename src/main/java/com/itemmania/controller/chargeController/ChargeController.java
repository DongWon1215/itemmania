package com.itemmania.controller.chargeController;

import com.itemmania.domain.ChargeRequest;
import com.itemmania.service.chargeService.ChargeInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/charge")
public class ChargeController {

    @Autowired
    ChargeInsertService chargeInsertService;

    @PostMapping
    public void saveChargeInfo(@RequestBody ChargeRequest chargeRequest){

        System.out.println(chargeRequest);
        System.out.println(chargeInsertService.insert(chargeRequest));

    }

}
