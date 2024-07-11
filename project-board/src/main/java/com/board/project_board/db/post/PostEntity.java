package com.board.project_board.db.post;


import com.board.project_board.db.post.enums.PostStatus;
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
@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long boardId;

    @Column(length = 50 , nullable = false)
    private String userName;

    @Column(length = 4 , nullable = false)
    private String password;

    @Column(length = 100 , nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @Column(length = 100 , nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;


    private LocalDateTime postedAt;
}
