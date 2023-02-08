package com.itemmania.service.buyService;

import com.itemmania.entity.BuyEntity;
import com.itemmania.entity.ItemEntity;
import com.itemmania.entity.MileageEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.BuyRepository;
import com.itemmania.repository.ItemRepository;
import com.itemmania.repository.MileageRepository;
import com.itemmania.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BuyService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    MileageRepository mileageRepository;
    @Autowired
    BuyRepository buyRepository;


    @Transactional
    public BuyEntity buy(UserEntity user, ItemEntity itemEntity, int count){

        BuyEntity buyEntity = new BuyEntity();
        buyEntity.setBuyItemUnit(count);
        buyEntity.setBuyPrice(itemEntity.getItemPrice() * count);
        buyEntity.setBuyTime(LocalDateTime.now());

        MileageEntity mileageEntity = MileageEntity.builder().
                userNum(user).
                mileageTime(LocalDateTime.now()).
                mileageType("구매").
                mileageOut(buyEntity.getBuyPrice())
                .build();

        buyEntity.setItemNum(itemEntity);
        buyEntity.setBuyPrice(buyEntity.getBuyItemUnit() * buyEntity.getItemNum().getItemPrice());


        buyEntity.setMileageNum(mileageRepository.save(mileageEntity));

        System.out.println(buyRepository.save(buyEntity));

        mileageEntity.setMileageDescription("#구매 : " + buyEntity.getBuyNum());

        System.out.println(mileageRepository.save(mileageEntity));

        return buyEntity;
    }

}
