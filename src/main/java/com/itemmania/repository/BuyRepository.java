package com.itemmania.repository;

import com.itemmania.entity.BuyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BuyRepository extends JpaRepository<BuyEntity,Integer> {

    List<BuyEntity> findByUserNum_UserNumAndTimeBetween(int userNum, LocalDate timeStart, LocalDate timeEnd);

}
