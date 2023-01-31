package com.itemmania.service.boardService;


import com.itemmania.domain.board.BoardDTO;
import com.itemmania.domain.board.BoardInsertRequest;
import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.GameServerEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.BoardRepository;
import com.itemmania.repository.GameServerEntityRepository;
import com.itemmania.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
public class BoardInsertService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private GameServerEntityRepository gameServerEntityRepository;
    @Autowired
    private UserRepository userRepository;



    // 검색 서버 출력
    public List<GameServerEntity> getGameServer(){
        return gameServerEntityRepository.findAllBy();
    }

    // 마이페이지 정보 출력
    public UserEntity selectMyInfo(int userNum){return userRepository.findById(userNum).get();}

    // 게시판 등록
    public BoardEntity insertBoard(BoardEntity boardEntity){
        return boardRepository.save(boardEntity);
    }

    // 파일 사진출력
    // 파일이 저장되는지 먼저 확인
    public int writeBoard(BoardInsertRequest boardInsertRequest){

        MultipartFile file = boardInsertRequest.getSalePhoto();

        File saveDir = null;
        String newFileName = null;

        if (file != null && !file.isEmpty() && file.getSize()>0){

/*             파일이 있는지없는지 여부확인
             폴더가 존재하지 않으면 생성
             생성후 저장해주는것 까지 확인하기*/

            String absolutePath = new File("").getAbsolutePath(); // 기본경로
            log.info(absolutePath);

            // == 만들고자하는 디렉토리 | 기본경로에 "photo"를 포함하고있는 디렉토리
            String path = "photo";                      // 가독성을 위하여 별도로 선언해주기
            saveDir = new File(absolutePath,path); // saveDir:저장하는 경로



            // == 폴더가 존재하지 않으면 생성
            if (!saveDir.exists()){  // 디렉토리가 존재하면 : true , 없으면 : false
                saveDir.mkdirs();
                log.info(">>>>>>>>>>>>>>>>>>photo dir 생성");
            }

            String uuid = UUID.randomUUID().toString(); // 난수발생
            newFileName = uuid+file.getOriginalFilename();  // 새로운 파일의 이름 생성

            // == 생성 후 파일 저장
            File newFile = new File(saveDir, newFileName); // 새로운 저장파일의 경로

            try {
                file.transferTo(newFile); // 파일 저장
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BoardEntity boardEntity = boardInsertRequest.insertBoard();
        if (newFileName != null){
            boardEntity.getSalePhoto();
        }

        int result = 0;

        // DB insert
        boardRepository.save(boardEntity);
        return result;
    }


}
