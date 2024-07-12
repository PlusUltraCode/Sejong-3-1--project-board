package com.board.project_board.api.domain.post.service;

import com.board.project_board.api.common.exception.ApiException;
import com.board.project_board.db.post.PostEntity;
import com.board.project_board.db.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostEntity register(PostEntity postEntity){
        return Optional.ofNullable(postEntity)
                .map(it->{
                    it.set
                    it.setPostedAt();
                    it.setStatus();
                })
                .orElseThrow(()-> new ApiException(new NullPointerException("error")));
    }
}
