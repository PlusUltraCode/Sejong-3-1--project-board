package com.board.project_board.api.domain.board.converter;

import com.board.project_board.api.common.annotation.Converter;
import com.board.project_board.api.domain.board.controller.model.BoardRegisterRequest;
import com.board.project_board.api.domain.board.controller.model.BoardResponse;
import com.board.project_board.db.board.BoardEntity;

@Converter
public class BoardConverter {

    public BoardEntity toEntity(BoardRegisterRequest request){

        return BoardEntity.builder()
                .boardName(request.getBoardName())
                .build();
    }

    public BoardResponse toResponse(BoardEntity boardEntity){

        return BoardResponse.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .build();
    }

}
