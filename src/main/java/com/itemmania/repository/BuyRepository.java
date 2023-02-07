package com.itemmania.repository;

import com.itemmania.entity.BuyEntity;
import com.itemmania.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BuyRepository extends JpaRepository<BuyEntity,Integer> {
    List<BuyEntity> findByMileageNum_UserNum(UserEntity userNum);



}
