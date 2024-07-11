package com.board.project_board.db.board;


import com.board.project_board.db.board.enums.BoardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100 , nullable = false)
    private String boardName;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    @Enumerated(EnumType.STRING)
    private BoardStatus status;
}
