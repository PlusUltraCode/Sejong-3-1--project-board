package com.board.project_board.api.domain.reply.business;

import com.board.project_board.api.common.annotation.Business;
import com.board.project_board.api.domain.post.converter.PostConverter;
import com.board.project_board.api.domain.post.service.PostService;
import com.board.project_board.api.domain.reply.controller.model.ReplyRegisterRequest;
import com.board.project_board.api.domain.reply.controller.model.ReplyResponse;
import com.board.project_board.api.domain.reply.converter.ReplyConverter;
import com.board.project_board.api.domain.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Business
@RequiredArgsConstructor
public class ReplyBusiness {

    private final ReplyService replyService;
    private final ReplyConverter replyConverter;

    private final PostService postService;
    private final PostConverter postConverter;

    public ReplyResponse register(
            ReplyRegisterRequest request,
            Long postId
    ){
        var postEntity = postService.getPostWithThrow(postId);

        var entity = replyConverter.toEntity(request,postEntity.getId());
        var newEntity = replyService.register(entity);
        var response = replyConverter.toResponse(newEntity);

        return response;
    }

    public List<ReplyResponse> viewList(
            Long postId
    ){
        var list = replyService.getAllList(postId);
        return list.stream()
                .map(replyConverter::toResponse)
                .toList();
    }

    public ReplyResponse viewOne(
            Long replyId
    ){
        var entity = replyService.getOneWithThrow(replyId);
        return replyConverter.toResponse(entity);
    }


}
