package com.itemmania.service.chargeService;

import com.itemmania.domain.ChargeRequest;
import com.itemmania.entity.MileageEntity;
import com.itemmania.entity.PayEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.MileageRepository;
import com.itemmania.repository.PayRepository;
import com.itemmania.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ChargeInsertService {

    @Autowired
    MileageRepository mileageRepository;
    @Autowired
    PayRepository payRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional
    public PayEntity insert(ChargeRequest chargeRequest){
        UserEntity user = userRepository.findById(chargeRequest.getUserNum()).get();

        userRepository.save(user);

        MileageEntity mileageEntity = MileageEntity.builder()
                .mileageDescription("#충전 : " + chargeRequest.getPg() + " / " + chargeRequest.getPayment())
                .mileageIn(chargeRequest.getPayAmount())
                .mileageOut(0)
                .mileageTime(LocalDateTime.now())
                .mileageType("충전")
                .userNum(user)
        .build();

        mileageRepository.save(mileageEntity);

        PayEntity payEntity = PayEntity.builder()
                .payPg(chargeRequest.getPg())
                .payTime(LocalDateTime.now())
                .payPayment(chargeRequest.getPayment())
                .payAmount(chargeRequest.getPayAmount())
                .mileageNum(mileageEntity)
                .build();

        return payRepository.save(payEntity);
    }

}
