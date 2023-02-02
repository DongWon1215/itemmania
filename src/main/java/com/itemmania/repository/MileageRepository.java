package com.itemmania.repository;

import com.itemmania.entity.MileageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface MileageRepository extends JpaRepository<MileageEntity, Integer> {
    Page<MileageEntity> findByUserNum_UserNumAndMileageTimeBetween(int userNum, LocalDateTime mileageTimeStart, LocalDateTime mileageTimeEnd, Pageable pageable);

}
