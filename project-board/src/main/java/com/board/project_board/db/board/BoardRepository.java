package com.board.project_board.db.board;

import com.board.project_board.db.board.enums.BoardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

    //특정 board 판 클릭시 보드판 정보를 보여주세요
    //select * from board where id = ? status = ? order By Id desc limit 1
    Optional<BoardEntity> findFirstByIdAndStatusOrderByIdDesc(Long id , BoardStatus status);

}
