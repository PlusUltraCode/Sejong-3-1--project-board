package com.board.project_board.api.domain.reply.service;

import com.board.project_board.db.reply.ReplyEntity;
import com.board.project_board.db.reply.ReplyRepository;
import com.board.project_board.db.reply.enums.ReplyStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    //생성하기
    public ReplyEntity register(
            ReplyEntity entity
    ){
        return Optional.ofNullable(entity)
                .map(it->{
                    it.setStatus(ReplyStatus.REGISTERED);
                    it.setRepliedAt(LocalDateTime.now());
                    return replyRepository.save(it);
                })
                .orElseThrow(()->new RuntimeException("error"));
    }

    public List<ReplyEntity> getAllList(
            Long postId
    ){
        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId,ReplyStatus.REGISTERED);

    }

    public ReplyEntity getOneWithThrow(
            Long replyId
    ){
        return replyRepository.findFirstByIdAndStatusOrderByIdDesc(replyId,ReplyStatus.REGISTERED)
                .orElseThrow(()->new RuntimeException("error"));
    }

}
