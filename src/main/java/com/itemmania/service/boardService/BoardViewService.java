package com.itemmania.service.boardService;

import com.itemmania.entity.BoardEntity;
import com.itemmania.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardViewService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardEntity> getList() {
        List<BoardEntity> all = boardRepository.findAll();
        return all;
    }



}
