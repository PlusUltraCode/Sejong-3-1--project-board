package com.board.project_board.db.reply;

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
@Entity
@Table(name = "reply")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false, length = 45)
    private String userName;

    @Column(columnDefinition = "varchar(100)", length=100)
    @Enumerated(EnumType.STRING)
    private ReplyStatus status;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;


    private LocalDateTime repliedAt;

    @Column(nullable = false, length = 45)
    private String password;
}
