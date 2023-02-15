package com.itemmania.controller.boardController.requestView;

import com.itemmania.entity.MileageEntity;
import com.itemmania.entity.TradeEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.MileageRepository;
import com.itemmania.repository.TradeRepository;
import com.itemmania.service.boardService.BoardListService;
import com.itemmania.service.boardService.BoardViewService;
import com.itemmania.service.mileageService.MileageInsertService;
import com.itemmania.service.mileageService.MileageViewService;
import com.itemmania.service.tradeService.BoardStateChangeService;
import com.itemmania.service.tradeService.TradeInsertService;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
//@RequestMapping("/buy_request")
@Log4j2
public class BoardRequestController {
    @Autowired
    private MileageRepository mileageRepository;
    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private BoardViewService boardViewService;

    @Autowired
    private UserService userService;

    @Autowired
    private BoardListService boardListService;

    @Autowired
    private TradeInsertService tradeInsertService;
    @Autowired
    private BoardStateChangeService boardStateChangeService;

    @Autowired
    private MileageViewService mileageViewService;

    @Autowired
    private MileageInsertService mileageInsertService;

    @GetMapping("/board/requestPage")
    public String getBoardRequest(
            @RequestParam(value = "boardNum") int boardNum, // 게시글번호
            @RequestParam(value = "deal") String dealCheck, // 판매,구매 구별
            Model model
    ) {
        log.info("BoardRequestController 들어옴");
        Model boardReq = model.addAttribute("boardReq", boardViewService.selectBoardView(boardNum));
        model.addAttribute("dealCheck", dealCheck);

        log.info("boardReq>>>>>>>>>>>>" + boardReq);


        if (dealCheck.equals("sale")) {
            log.info("팝니다 요청페이지!!!! 들어감");
            return "board/requestPage/boardSaleRequest";
        } else
            return "errors/500";

    }

    @PostMapping("/board/requestPage")
    public String postBoardRequest(@RequestParam("sellerNum") int sellerNum,
                                   HttpServletRequest request
            , TradeEntity tradeEntity) {
        log.info("입장 " + tradeEntity);
        log.info("sellerMileage >>" + sellerNum);


        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        log.info("로그인유저 객체" + user);


        Optional<UserEntity> seller = userService.getUserEntity(sellerNum);

        log.info("판매자 userNum객체" + seller.get());


        //판매자
        MileageEntity setSellerMileage = MileageEntity.builder()
                .userNum(seller.get())
                .mileageTime(LocalDateTime.now())
                .mileageType("판매")
                .mileageDescription("#판매 : " + tradeEntity.getBoardNum().getBoardNum())
                .mileageIn(tradeEntity.getTradeAmount())
                .mileageOut(0)
                .build();
        //구매자
        MileageEntity setConsumerMileage = MileageEntity.builder()
                .userNum(user)
                .mileageTime(LocalDateTime.now())
                .mileageType("구매")
                .mileageDescription("#구매 : " + tradeEntity.getBoardNum().getBoardNum())
                .mileageIn(0)
                .mileageOut(tradeEntity.getTradeAmount())
                .build();

        MileageEntity mileag1e = mileageInsertService.setMileage(setSellerMileage);
        MileageEntity mileage = mileageInsertService.setMileage(setConsumerMileage);
        log.info("mileagesel" + mileag1e);
        log.info("mileagecon" + mileage);

//        mileageInsertService.setMileage(mile);

        tradeEntity.setConsumerMileage(setConsumerMileage);
        tradeEntity.setSellerMileage(setSellerMileage);

        log.info("입력 후 tradeEntity 확인" + tradeEntity);

        /*trade테이블에 저장*/
        TradeEntity insert = tradeInsertService.setTradeInsert(tradeEntity);
        log.info("x>>" + insert);

        log.info("변경할 보드번호" + tradeEntity.getBoardNum());

        /*board_trade_status 상태값을 2로 변경*/
        boardStateChangeService.boardStateChange(tradeEntity.getBoardNum());
     /*   PrintWriter out = response.getWriter();
        out.println("<script>alert('" + "입력되었습니다." + "');</script> ");
        out.flush();*/

        return "UserForm/myRoom/trade/buyRegister";
    }
}



/* 판매자, 구매자 마일리지 내역 PK(userNum을 이용해서 mileage테이블 PK값을 가져오려 했는데 엔티티가 해줘서 불필요한 코드였음)
        int seller_mileage = scheduledService.getSeller_Consumer_mileage(tradeEntity.getConsumerMileage().getMileageNum());
        int consumer_mileage = scheduledService.getSeller_Consumer_mileage(tradeEntity.getSellerMileage().getMileageNum());

        log.info("seller_mileage" + seller_mileage);
        log.info("consumer_mileage" + consumer_mileage);

        tradeEntity.setSellerMileage2(seller_mileage);
        tradeEntity.setConsumerMileage2(consumer_mileage);

  Optional<UserEntity> seller = userService.getUserEntity(sellerMileage);
        Optional<UserEntity> consumer = userService.getUserEntity(consumerMileage);

         */