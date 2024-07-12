package com.board.project_board.api.domain.post.controller;

import com.board.project_board.api.domain.post.business.PostBusiness;
import com.board.project_board.api.domain.post.controller.model.PostRegisterRequest;
import com.board.project_board.api.domain.post.controller.model.PostResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostBusiness postBusiness;

    //생성

    @PostMapping("/register")
    public ResponseEntity<PostResponse> register(
            @Valid
            @RequestBody PostRegisterRequest request,

            @RequestParam(name = "boardId") Long boardId
    ) {
        var response = postBusiness.register(request,boardId);
        return ResponseEntity.status(200)
                .body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<PostResponse> search(
            @RequestParam(name = "postId") Long postId
    ){
        var response = postBusiness.getOnePost(postId);
        return ResponseEntity.status(200)
                .body(response);
    }


}
