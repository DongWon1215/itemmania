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

    // 체크한 dealCheck + 사용자가 입력한 게임 or 게임서버 결과를 리스트로 받음
    @Query("""
            select b from BoardEntity b
            where b.salePremium = ?1 and b.dealCheck = ?2 and b.serverNum.gameNum.gameName = ?3 or b.serverNum.gameServerName = ?4""")
    List<BoardEntity> boardSearchList(int premium, String dealCheck, String gameName, String gameServerName);

    // 체크한 dealCheck + 사용자가 입력한 게임 or 게임서버 결과를 리스트로 받음
    @Query("""
            select b from BoardEntity b
            where b.salePremium = :premium and b.dealCheck = :dealCheck and b.serverNum.gameNum.gameName = ?3 or b.serverNum.gameServerName = ?4""")
    List<BoardEntity> boardP_SearchList(int premium, String dealCheck, String gameName, String gameServerName);


    @Transactional
    @Modifying  // insert, update, delete
    /*@Query("delete from BoardEntity b where b.boardNum = ?1")*/

    @Query("delete from BoardEntity b where b.boardNum = :boardNum")
    int deleteByBno(@Param("boardNum") Integer boardNum);

}
   /*


        INSERT INTO `proj`.`board` (
        `board_time`, `board_title`, `board_trade_status`, `deal_check`,
        `server_num`, `sale_aria`, `sale_nick_name`, `sale_photo`, `sale_premium`,
        `sale_price`, `sale_type`, `sale_unit`, `user_num`)
        VALUES ( '2020-02-02', '게시판 제목sale',0, 'sale', '6',
        '상세설명', '본인닉네임', '등록사진', 1, '999',  0,'1','1');




        */

/*


    INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('루페온', '1');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('아만', '1');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('카제로스', '1');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('카마인', '1');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('엘리시움', '2');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('루나', '2');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('유니온', '2');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('스카니아', '2');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('오딘1', '3');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('오딘2', '3');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('오딘3', '3');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('오딘4', '3');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('시로코', '4');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('카시야스', '4');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('디레지에', '4');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('바칼', '4');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('이스라펠', '5');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('네자칸', '5');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('지켈', '5');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('트리니엘', '5');
        INSERT INTO `proj`.`game_server` (`game_server_name`, `game_num`) VALUES ('기타', '6');


        */
/*


    INSERT INTO `proj`.`game` (`game_name`, `game_currency`) VALUES ('로스트아크', '골드');
        INSERT INTO `proj`.`game` (`game_name`, `game_currency`) VALUES ('메이플스토리', '메소');
        INSERT INTO `proj`.`game` (`game_name`, `game_currency`) VALUES ('오딘', '다이야');
        INSERT INTO `proj`.`game` (`game_name`, `game_currency`) VALUES ('던전앤파이터', '골드');
        INSERT INTO `proj`.`game` (`game_name`, `game_currency`) VALUES ('아이온', '키나');
        INSERT INTO `proj`.`game` (`game_name`, `game_currency`) VALUES ('서든어택', 'SP');


        */
