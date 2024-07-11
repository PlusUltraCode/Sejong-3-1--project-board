package com.board.project_board.db.post.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PostStatus {

    REGISTERED("등록"),
    UNREGISTERED("해제"),
    ;

    private String status;
}
