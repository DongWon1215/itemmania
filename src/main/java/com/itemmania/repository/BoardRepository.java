package com.itemmania.repository;

import com.itemmania.entity.BoardEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    // sale buy 구분출력
    List<BoardEntity> findByDealCheck(String DealCheck);

    // 구매 판매 구분하고 프리미엄만 출력
    @Query("select b from BoardEntity b where b.dealCheck = ?1 and b.salePremium = ?2 ")
    List<BoardEntity> boardListPremium(String dealCheck, boolean yes);

    // 구매 판매 구분하고 프리미엄 아닌것 출력
    @Query("select b from BoardEntity b where b.dealCheck = ?1 and b.salePremium = ?2")
    List<BoardEntity> boardListNotPremium(String dealCheck, boolean no);






    @Transactional
    @Modifying  // insert, update, delete
    /*@Query("delete from BoardEntity b where b.boardNum = ?1")*/

    @Query("delete from BoardEntity b where b.boardNum = :boardNum")
    int deleteByBno(@Param("boardNum") Integer boardNum);

}
   /* INSERT INTO `proj`.`board` (
        `board_time`, `board_title`, `board_trade_status`, `deal_check`, `game_num`,
        `game_server`, `sale_aria`, `sale_nick_name`, `sale_photo`, `sale_premium`,
        `sale_price`, `sale_type`, `sale_unit`, `user_num`)
        VALUES ( '2020-02-02', '게시판 제목sale',0, 'sale', '1', '1',
        '상세설명', '본인닉네임', '등록사진', 0, '999',  0,'1','1');*/