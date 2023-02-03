package com.itemmania;

import com.itemmania.entity.*;
import com.itemmania.repository.*;
import com.itemmania.service.userService.MyMileageDetailListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @Autowired
    private MileageRepository mileageRepository;

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
        buyEntity.setBuyItemUnit(3);
        UserEntity user = userRepository.findById(1).get();
        MileageEntity mileageEntity = MileageEntity.builder().
                userNum(user).
                mileageTime(LocalDateTime.now()).
                mileageType("구매").
                mileageOut(buyEntity.getBuyPrice()).
                mileageHistory(user.getUserMileage() - buyEntity.getBuyPrice())
                .build();

        ItemEntity itemEntity = itemRepository.findById(1).get();
        buyEntity.setItemNum(itemEntity);
        buyEntity.setBuyPrice(buyEntity.getBuyItemUnit() * buyEntity.getItemNum().getItemPrice());
        buyEntity.setMileageNum(mileageRepository.save(mileageEntity));

        user.setItemUnit(user.getItemUnit()+buyEntity.getBuyItemUnit());
        user.setItemNum(itemRepository.findById(1).get());
        System.out.println(buyRepository.save(buyEntity));
        System.out.println(userRepository.save(user));

        mileageEntity.setMileageDescription("#구매 : " + buyEntity.getBuyNum());

        System.out.println(mileageRepository.save(mileageEntity));
    }

    @Test
    public void boardTest(){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardTitle("테스트");
        boardEntity.setBoardTime(LocalDateTime.now());
        boardEntity.setBoardTradeStatus(0);

        boardRepository.save(boardEntity);
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

        MileageEntity sellerMileage = new MileageEntity();
        MileageEntity consumerMileage = new MileageEntity();

        sellerMileage.setMileageIn(500);
        user.setUserMileage(user.getUserMileage()+500);
        sellerMileage.setMileageHistory(user.getUserMileage());
        sellerMileage.setMileageTime(LocalDateTime.now());
        sellerMileage.setMileageType("판매");
        String description = "#판매 : ";
        int boardNum = boardRepository.findById(1).get().getBoardNum();
        description += boardNum;
        sellerMileage.setMileageDescription(description);
        sellerMileage.setUserNum(user);

        consumerMileage.setMileageOut(500);
        user2.setUserMileage(user2.getUserMileage()-500);
        consumerMileage.setMileageHistory(user2.getUserMileage());
        consumerMileage.setMileageTime(LocalDateTime.now());
        consumerMileage.setMileageType("구매");
        description = "#구매 : " + boardRepository.findById(1).get().getBoardNum();
        consumerMileage.setMileageDescription(description);
        consumerMileage.setUserNum(user2);

        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setSellerMileage(sellerMileage);
        tradeEntity.setConsumerMileage(consumerMileage);
        tradeEntity.setTradeTime(LocalDateTime.now());
        tradeEntity.setTradeIsSuccess(true);
        tradeEntity.setTradeAmount(500);
        tradeEntity.setTradeUnit(1);

        userRepository.save(user);
        userRepository.save(user2);
        System.out.println(mileageRepository.save(sellerMileage));
        System.out.println(mileageRepository.save(consumerMileage));
        System.out.println(tradeRepository.save(tradeEntity));
    }


    @Test
    public void getMyMileageDetailListTest(){
        UserEntity user = userRepository.findById(1).get();
        LocalDateTime startDate = LocalDateTime.of(1,1,1,1,1);
        LocalDateTime endDate = LocalDateTime.now();

        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "mileageTime");

        System.out.println(myMileageDetailListService.getList(user.getUserNum(), startDate, endDate, pageable) + "@@@@@@@@@@");
    }

}
