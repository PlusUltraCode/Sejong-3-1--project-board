package com.board.project_board.api.domain.reply.controller.model;

import com.board.project_board.db.reply.enums.ReplyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyResponse {

    private Long id;

    private Long postId;

    private String userName;

    private ReplyStatus status;

    private String title;

    private String content;

    private LocalDateTime repliedAt;

}
