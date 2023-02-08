package com.itemmania.repository;

import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.MileageEntity;
import com.itemmania.entity.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TradeRepository extends JpaRepository<TradeEntity,Integer> {

}
