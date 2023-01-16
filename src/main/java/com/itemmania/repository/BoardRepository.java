package com.itemmania.repository;

import com.itemmania.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    // sale buy 구분출력
    List<BoardEntity> findByDealCheck(String DealCheck);

}
   /* INSERT INTO `proj`.`board` (
        `board_time`, `board_title`, `board_trade_status`, `deal_check`, `game_num`,
        `game_server`, `sale_aria`, `sale_nick_name`, `sale_photo`, `sale_premium`,
        `sale_price`, `sale_type`, `sale_unit`, `user_num`)
        VALUES ( '2020-02-02', '게시판 제목sale',0, 'sale', '1', '1',
        '상세설명', '본인닉네임', '등록사진', 0, '999',  0,'1','1');*/