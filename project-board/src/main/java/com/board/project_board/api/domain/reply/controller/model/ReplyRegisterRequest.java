package com.board.project_board.api.domain.reply.controller.model;

import com.board.project_board.db.reply.enums.ReplyStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyRegisterRequest {

    @NotBlank
    private String userName;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private String password;

}
