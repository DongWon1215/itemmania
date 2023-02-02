package com.itemmania.service.userService;

import com.itemmania.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MyRoomUserLeaveService {

    @Autowired
    private UserRepository userRepository;

    // 회원 삭제 서비스
    public int deleteUser(int userNum){

        log.info("delete user......." + userNum);
        return userRepository.deleteByUserNum(userNum);

    }



}
