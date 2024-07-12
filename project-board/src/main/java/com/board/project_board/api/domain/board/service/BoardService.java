package com.board.project_board.api.domain.board.service;

import com.board.project_board.api.common.exception.ApiException;
import com.board.project_board.db.board.BoardEntity;
import com.board.project_board.db.board.BoardRepository;
import com.board.project_board.db.board.enums.BoardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //등록
    public BoardEntity register(BoardEntity boardEntity){
        return Optional.ofNullable(boardEntity)
                .map(it->{
                    it.setStatus(BoardStatus.REGISTERED);
                    return boardRepository.save(it);
                })
                .orElseThrow(()->new ApiException(new NullPointerException("boardEntity is null")));
    }


    //조회
    //특정 보드판 클릭시 -> 보드판 정보 보여주기
    public BoardEntity search(Long id){

        var entity = boardRepository.findFirstByIdAndStatusOrderByIdDesc(id,BoardStatus.REGISTERED);
        return entity.orElseThrow(()->new ApiException(new NullPointerException("boardEntity is null")));
    }
}
