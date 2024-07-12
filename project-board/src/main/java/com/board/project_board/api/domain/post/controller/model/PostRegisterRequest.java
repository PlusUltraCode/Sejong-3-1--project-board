package com.board.project_board.api.domain.post.controller.model;

import com.board.project_board.db.post.enums.PostStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRegisterRequest {

    @NotBlank
    private String userName;

    @NotNull
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
