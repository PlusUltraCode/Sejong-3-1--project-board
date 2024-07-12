package com.board.project_board.api.domain.board.business;

import com.board.project_board.api.common.annotation.Business;
import com.board.project_board.api.domain.board.controller.model.BoardRegisterRequest;
import com.board.project_board.api.domain.board.controller.model.BoardResponse;
import com.board.project_board.api.domain.board.converter.BoardConverter;
import com.board.project_board.api.domain.board.service.BoardService;
import com.board.project_board.db.board.BoardEntity;
import lombok.RequiredArgsConstructor;

@Business
@RequiredArgsConstructor
public class BoardBusiness {

    private final BoardService boardService;
    private final BoardConverter boardConverter;

    //request -> convertr이용해 entity
    //entit -> service저장을이용해 newEntit
    // newENtit - > response 변환후 리턴
    public BoardResponse register(BoardRegisterRequest request){

        var entity = boardConverter.toEntity(request);
        var newEntity = boardService.register(entity);
        var response = boardConverter.toResponse(newEntity);

        return response;
    }

    public BoardResponse search(Long id){

        var newEntity = boardService.search(id);
        var response = boardConverter.toResponse(newEntity);

        return response;
    }
}
