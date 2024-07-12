package com.board.project_board.api.domain.post.service;

import com.board.project_board.api.common.exception.ApiException;
import com.board.project_board.db.board.BoardEntity;
import com.board.project_board.db.post.PostEntity;
import com.board.project_board.db.post.PostRepository;
import com.board.project_board.db.post.enums.PostStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostEntity register(
            PostEntity postEntity,
            Long boardId

    ){
        return Optional.ofNullable(postEntity)
                .map(it->{
                    it.setPostedAt(LocalDateTime.now());
                    it.setStatus(PostStatus.REGISTERED);
                    it.setBoardId(boardId);
                    return postRepository.save(it);
                })
                .orElseThrow(()-> new ApiException(new NullPointerException("error")));
    }

    //보여주기
    //특정 보드판 클릭시 보여주기
    public List<PostEntity> getAllList(
            Long boardId
    ){
        var list = postRepository.findAllByBoardIdAndStatusOrderByIdDesc(boardId,PostStatus.REGISTERED);
        return list;
    }

    //특정 포스터 클릭시 포스터 정보 보여주기
    public PostEntity getPostWithThrow(
            Long id
    ){
        var entity = postRepository.findFirstByIdAndStatus(id,PostStatus.REGISTERED);
        return entity.orElseThrow(()->new ApiException(new RuntimeException("error")));

    }

}
