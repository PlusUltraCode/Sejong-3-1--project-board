package com.board.project_board.db.reply.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ReplyStatus {
    REGISTERED("등록"),
    UNREGISTERED("해제"),
    ;

    private String status;
}
