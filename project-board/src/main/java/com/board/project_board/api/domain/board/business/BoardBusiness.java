package com.board.project_board.api.domain.board.business;

import com.board.project_board.api.common.annotation.Business;
import com.board.project_board.api.domain.board.controller.model.BoardRegisterRequest;
import com.board.project_board.api.domain.board.controller.model.BoardResponse;
import com.board.project_board.api.domain.board.converter.BoardConverter;
import com.board.project_board.api.domain.board.service.BoardService;
import com.board.project_board.api.domain.post.converter.PostConverter;
import com.board.project_board.api.domain.post.service.PostService;
import com.board.project_board.db.board.BoardEntity;
import com.board.project_board.db.post.enums.PostStatus;
import lombok.RequiredArgsConstructor;

@Business
@RequiredArgsConstructor
public class BoardBusiness {

    private final BoardService boardService;
    private final BoardConverter boardConverter;

    private final PostService postservice;
    private final PostConverter postconverter;

    //request -> convertr이용해 entity
    //entit -> service저장을이용해 newEntit
    // newENtit - > response 변환후 리턴
    public BoardResponse register(BoardRegisterRequest request){

        var entity = boardConverter.toEntity(request);
        var newEntity = boardService.register(entity);
        var response = boardConverter.toResponse(newEntity,null);

        return response;
    }

    public BoardResponse search(Long id){

        var postEntityList = postservice.getAllList(id);
        var postResponseList = postEntityList.stream()
                .map(postconverter::toResponse)
                .toList();

        var newEntity = boardService.search(id);
        var response = boardConverter.toResponse(newEntity, postResponseList);

        return response;
    }
}
