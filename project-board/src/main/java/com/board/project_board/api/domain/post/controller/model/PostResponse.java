package com.board.project_board.api.domain.post.controller.model;

import com.board.project_board.api.domain.reply.controller.model.ReplyResponse;
import com.board.project_board.db.post.enums.PostStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {

    private Long id;

    private Long boardId;

    private String userName;

    private String email;

    private PostStatus status;

    private String title;

    private String content;

    private LocalDateTime postedAt;

    private List<ReplyResponse> replyResponseList = List.of();
}
