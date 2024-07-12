package com.board.project_board.api.domain.reply.controller;

import com.board.project_board.api.domain.reply.business.ReplyBusiness;
import com.board.project_board.api.domain.reply.controller.model.ReplyRegisterRequest;
import com.board.project_board.api.domain.reply.controller.model.ReplyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController {

    private final ReplyBusiness replyBusiness;

    @PostMapping("/register/postId/{postId}")
    public ResponseEntity<ReplyResponse> register(
            @Valid
            @RequestBody ReplyRegisterRequest request,

            @PathVariable(name ="postId") Long postId
    ){
        var response = replyBusiness.register(request,postId);
        return ResponseEntity.status(200)
                .body(response);
    }


}