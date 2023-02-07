package com.itemmania;

import com.itemmania.entity.BuyEntity;
import com.itemmania.entity.ItemEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.ItemRepository;
import com.itemmania.repository.UserRepository;
import com.itemmania.service.buyService.BuyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuyServiceTest {

    @Autowired
    private BuyService buyService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void buyTest(){

        UserEntity user = userRepository.findById(1).get();
        ItemEntity item = itemRepository.findById(1).get();
        int count = 3;

        BuyEntity buyEntity = buyService.buy(user, item, count);

        System.out.println(buyEntity);
    }
}
