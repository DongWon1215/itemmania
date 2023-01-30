package com.itemmania;

import com.itemmania.domain.UserModifyRequest;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@Log4j2
@SpringBootTest
public class MyroomTest {

    @Autowired
    private UserRepository userRepository;

    // 회원 수정 테스트 -> 완료
    @Test
    public void updateMemberTest(){
        userRepository.updateUserByUserNum("tester", "tester", "tester", LocalDate.parse("2000-06-12"), 1);
        log.info("회원 수정...");
    }

}
