package com.itemmania.repository;

import com.itemmania.entity.MileageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MileageRepository extends JpaRepository<MileageEntity, Integer> {
    Page<MileageEntity> findByUserNum_UserNumAndMileageTimeBetween(int userNum, LocalDateTime mileageTimeStart, LocalDateTime mileageTimeEnd, Pageable pageable);

    List<MileageEntity> findByUserNum_UserNum(int userNum);


    /*판매자, 구매자 마일리지 userNum으로 검색하여 PK중 최대값 조회하기*/
    @Query("select max (m.mileageNum) from MileageEntity m where m.userNum.userNum = ?1 ")
    Integer findTop1ByUserNum(int userNum);

}
