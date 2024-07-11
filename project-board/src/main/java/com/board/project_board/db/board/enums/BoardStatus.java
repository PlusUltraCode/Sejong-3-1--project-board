package com.board.project_board.db.board.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BoardStatus {

    REGISTERED("등록"),
    UNREGISTERED("해제"),
    ;

    private String status;
}
