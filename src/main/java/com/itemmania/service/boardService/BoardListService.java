package com.itemmania.service.boardService;

import com.itemmania.entity.BoardEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
@Log4j2
@Service
public class BoardListService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardEntity> getList() {
       log.info("BoardListService 들어옴");
        List<BoardEntity> all = boardRepository.findAll();
       log.info("BoardListService 탈출");
        return all;
    }

public interface BoardListService {

    //모든 리스트 출력
    /*List<BoardEntity> getAllList();*/

    //구매,판매 리스트 출력
    List<BoardEntity> getDealCheckList(String DealCheck, boolean no);

    //구매,판매 프리미엄 리스트 출력
    List<BoardEntity> getDealCheckPremiumList(String DealCheck , boolean yes);


}
