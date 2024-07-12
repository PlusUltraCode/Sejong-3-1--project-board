package com.board.project_board.api.common.exception;

public class ApiException extends RuntimeException{

    public ApiException(Throwable tx){
        super(tx);
    }
}
