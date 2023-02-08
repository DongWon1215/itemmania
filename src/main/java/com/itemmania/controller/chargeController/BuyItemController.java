package com.itemmania.controller.chargeController;

import com.itemmania.domain.BuyRequestDTO;
import com.itemmania.domain.Item.ItemBuyRequest;
import com.itemmania.entity.BuyEntity;
import com.itemmania.entity.ItemEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.ItemRepository;
import com.itemmania.service.buyService.BuyService;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Log4j2
public class BuyItemController {

    @Autowired
    private BuyService buyService;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/buy")
    public BuyRequestDTO BuyingTicket(@RequestBody ItemBuyRequest itemBuyRequest, HttpServletRequest request)
    {
        log.info("itemRequestInfo =======================>" + itemBuyRequest);

        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        ItemEntity item = itemRepository.getReferenceById(itemBuyRequest.getItemSerialNum());

        BuyEntity buyEntity = buyService.buy(user,item,itemBuyRequest.getItemNum());

        return buyEntity.to_DTO();
    }

}
