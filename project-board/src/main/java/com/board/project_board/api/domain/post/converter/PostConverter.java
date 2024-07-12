package com.board.project_board.api.domain.post.converter;

import com.board.project_board.api.common.annotation.Converter;
import com.board.project_board.api.domain.post.controller.model.PostRegisterRequest;
import com.board.project_board.api.domain.post.controller.model.PostResponse;
import com.board.project_board.api.domain.reply.converter.ReplyConverter;
import com.board.project_board.db.post.PostEntity;
import com.board.project_board.db.reply.ReplyEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Converter
@RequiredArgsConstructor
public class PostConverter {

    private final ReplyConverter replyConverter;

    public PostEntity toEntity(PostRegisterRequest request){
        return PostEntity.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(request.getPassword())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public PostResponse toResponse(
            PostEntity postEntity
    ){

        return PostResponse.builder()
                .id(postEntity.getId())
                .boardId(postEntity.getBoardId())
                .userName(postEntity.getUserName())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .email(postEntity.getEmail())
                .postedAt(postEntity.getPostedAt())
                .status(postEntity.getStatus())
                .build();
    }

    public PostResponse toResponse(
            PostEntity postEntity,
            List<ReplyEntity> replyEntityList
    ){
        var replyResponseList = replyEntityList
                .stream()
                .map(replyConverter::toResponse)
                .toList();

        return PostResponse.builder()
                .id(postEntity.getId())
                .replyResponseList(replyResponseList)
                .boardId(postEntity.getBoardId())
                .userName(postEntity.getUserName())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .email(postEntity.getEmail())
                .postedAt(postEntity.getPostedAt())
                .status(postEntity.getStatus())
                .build();
    }

}
