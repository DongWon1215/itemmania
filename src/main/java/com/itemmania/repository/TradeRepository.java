package com.itemmania.repository;

import com.itemmania.entity.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TradeRepository extends JpaRepository<TradeEntity,Integer> {

}
