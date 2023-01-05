package com.itemmania.service.boardService;

import com.itemmania.mapper.BoardMapper;
import com.itemmania.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired(required = false)
    private BoardRepository boardRepository;

    @Autowired(required = false)
    private BoardMapper boardMapper;

}
