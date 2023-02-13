package com.itemmania.service.boardService;

import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardInNameOutnumService {

    @Autowired
    BoardRepository boardRepository;


    /*유저이름을 넣으면 유저번호로 반환하는 서비스*/
    public UserEntity getUserNum(String userName) {
        return boardRepository.findByUserNamegetUserNum(userName);
    }
}
