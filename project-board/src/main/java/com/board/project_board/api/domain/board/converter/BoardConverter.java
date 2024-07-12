package com.board.project_board.api.domain.board.converter;

import com.board.project_board.api.common.annotation.Converter;
import com.board.project_board.api.domain.board.controller.model.BoardRegisterRequest;
import com.board.project_board.api.domain.board.controller.model.BoardResponse;
import com.board.project_board.api.domain.post.controller.model.PostResponse;
import com.board.project_board.db.board.BoardEntity;
import com.board.project_board.db.post.PostEntity;

import java.util.List;

@Converter
public class BoardConverter {

    public BoardEntity toEntity(BoardRegisterRequest request) {

        return BoardEntity.builder()
                .boardName(request.getBoardName())
                .build();
    }

    public BoardResponse toResponse(
            BoardEntity boardEntity,
            List<PostResponse> postResponseList
    ) {

        return BoardResponse.builder()
                .id(boardEntity.getId())
                .postResponseList(postResponseList)
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .build();
    }

}
