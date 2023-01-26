package com.itemmania;

import com.itemmania.entity.*;
import com.itemmania.repository.*;
import com.itemmania.service.userService.MyMileageDetailListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    BuyRepository buyRepository;
    @Autowired
    PayRepository payRepository;
    @Autowired
    TradeRepository tradeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MyMileageDetailListService myMileageDetailListService;

    @Test
    public void userRepositoryTest(){
        UserEntity user = new UserEntity();
        user.setUserBirth(LocalDate.of(1997, 6, 3));
        user.setUserEmail("mngjs70@gmail.com");
        user.setUserMileage(1000);
        user.setUserIsManager(true);
        user.setUserName("test");
        user.setUserPassword("1111");
        user.setUserRealName("tester");
        user.setUserPhoneNumber("010-1111-1111");
        user.setUserCreditScore(0);

        System.out.println(userRepository.save(user));

    }

    @Test
    public void itemRepositoryTest(){
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemName("프리미엄 등록권");
        itemEntity.setItemPrice(100);
        itemRepository.save(itemEntity);
    }

    @Test
    public void buyRepositoryTest(){
        BuyEntity buyEntity = new BuyEntity();
        buyEntity.setItemUnit(3);

        ItemEntity itemEntity = itemRepository.findById(1).get();
        buyEntity.setItemNum(itemEntity);
        buyEntity.setPrice(buyEntity.getItemUnit() * buyEntity.getItemNum().getItemPrice());
        buyEntity.setUserNum(userRepository.findById(1).get());
        buyEntity.setTime(LocalDate.now());

        UserEntity user = userRepository.findById(1).get();
        user.setItemUnit(user.getItemUnit()+buyEntity.getItemUnit());
        user.setItemNum(itemRepository.findById(1).get());
        System.out.println(buyRepository.save(buyEntity));
        System.out.println(userRepository.save(user));
    }

    @Test
    public void tradeRepositoryTest(){
        UserEntity user = userRepository.findById(1).get();
        UserEntity user2 = new UserEntity();
        user2.setItemNum(itemRepository.findById(1).get());
        user2.setUserName("test2");
        user2.setUserPassword("1111");
        user2.setUserIsManager(false);
        user2.setUserPhoneNumber("010-2222-2222");
        user2.setUserCreditScore(0);
        user2.setUserBirth(LocalDate.of(2002, 2, 2));
        user2.setUserMileage(10000);
        user2.setUserCreditScore(0);
        user2.setUserEmail("222@22.22");
        user2.setUserRealName("tester2");
        userRepository.save(user2);

        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setSellerNum(user);
        tradeEntity.setConsumerNum(user2);
        tradeEntity.setTradeTime(LocalDate.now());
        tradeEntity.setTradeIsSuccess(true);
        tradeEntity.setTradeAmount(500);
        tradeEntity.setTradeUnit(1);

        user.setUserMileage(user.getUserMileage()+500);
        user2.setUserMileage(user2.getUserMileage()-500);
        userRepository.save(user);
        userRepository.save(user2);
        tradeRepository.save(tradeEntity);
    }

    @Test
    public void boardTest(){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardTitle("테스트");
        boardEntity.setBoardTime(LocalDate.now());
        boardEntity.setBoardTradeStatus(false);

        boardRepository.save(boardEntity);
    }

    @Test
    public void tradeTest(){

        UserEntity user = userRepository.findById(1).get();

        UserEntity user2 = userRepository.findById(2).get();

        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setSellerNum(user);
        tradeEntity.setConsumerNum(user2);
        tradeEntity.setTradeTime(LocalDate.now());
        tradeEntity.setTradeIsSuccess(true);
        tradeEntity.setTradeAmount(1500);
        tradeEntity.setTradeUnit(1);
        tradeEntity.setBoardNum(boardRepository.findById(1).get());

        tradeRepository.save(tradeEntity);
    }

    @Test
    public void getMyMileageDetailListTest(){
        UserEntity user = userRepository.findById(1).get();
        LocalDate startDate = LocalDate.of(1,1,1);
        LocalDate endDate = LocalDate.now();

        System.out.println(myMileageDetailListService.getList(user.getUserNum(), startDate, endDate));
    }

}
