package com.itemmania.repository;

import com.itemmania.entity.PayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PayRepository extends JpaRepository<PayEntity,Integer> {

    List<PayEntity> findByUserNum_UserNumAndPayTimeBetween(int userNum, LocalDate payTimeStart, LocalDate payTimeEnd);

}
