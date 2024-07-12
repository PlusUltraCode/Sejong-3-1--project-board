package com.board.project_board.api.domain.reply.converter;

import com.board.project_board.api.common.annotation.Converter;
import com.board.project_board.api.domain.reply.controller.model.ReplyRegisterRequest;
import com.board.project_board.api.domain.reply.controller.model.ReplyResponse;
import com.board.project_board.db.reply.ReplyEntity;
import com.board.project_board.db.reply.enums.ReplyStatus;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Converter
@RequiredArgsConstructor
public class ReplyConverter {

    public ReplyEntity toEntity(
            ReplyRegisterRequest request,
            Long postId
    ){
        return ReplyEntity.builder()
                .postId(postId)
                .userName(request.getUserName())
                .title(request.getTitle())
                .content(request.getContent())
                .password(request.getPassword())
                .build();
    }

    public ReplyResponse toResponse(
            ReplyEntity entity
    ){
        return ReplyResponse.builder()
                .id(entity.getId())
                .postId(entity.getPostId())
                .userName(entity.getUserName())
                .status(entity.getStatus())
                .title(entity.getTitle())
                .content(entity.getContent())
                .repliedAt(entity.getRepliedAt())
                .build();
    }
}
