package com.board.project_board.api.domain.board.controller.model;

import com.board.project_board.api.domain.post.controller.model.PostResponse;
import com.board.project_board.db.board.enums.BoardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardResponse {

    private Long id;

    private String boardName;

    private BoardStatus status;

    private List<PostResponse> postResponseList = List.of();
}
