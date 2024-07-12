package com.board.project_board.api.domain.post.business;

import com.board.project_board.api.common.annotation.Business;
import com.board.project_board.api.domain.board.service.BoardService;
import com.board.project_board.api.domain.post.controller.model.PostRegisterRequest;
import com.board.project_board.api.domain.post.controller.model.PostResponse;
import com.board.project_board.api.domain.post.converter.PostConverter;
import com.board.project_board.api.domain.post.service.PostService;
import com.board.project_board.api.domain.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Business
@RequiredArgsConstructor
public class PostBusiness {

    private final BoardService boardService;

    private final PostService postService;
    private final PostConverter postConverter;

    private final ReplyService replyService;

    public PostResponse register(
            PostRegisterRequest request,
            Long boardId
    ){
        System.out.println(boardId+"------------------------------");
        var boardEntity = boardService.search(boardId);

        var entity = postConverter.toEntity(request);
        var newEntity = postService.register(entity,boardEntity.getId());
        var response = postConverter.toResponse(newEntity);

        return response;
    }

    public List<PostResponse> getAllList(
            Long boardId
    ){
        var list = postService.getAllList(boardId);
        return list.stream()
                .map(postConverter::toResponse).toList();
    }

    public PostResponse getOnePost(
            Long postId
    ){
        var replyEntityList = replyService.getAllList(postId);


        var entity = postService.getPostWithThrow(postId);
        var response = postConverter.toResponse(entity,replyEntityList);

        return response;
    }

}
