package com.board.project_board.db.reply;

import com.board.project_board.db.reply.enums.ReplyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity,Long> {

    //해당 글을 클릭하여 post_id 를 전달받고 자신의 응답또한 줘야된다.
    //select * from reply where post_id = ? and status = ? order by id desc;
    List<ReplyEntity> findAllByPostIdAndStatusOrderByIdDesc(Long postId, ReplyStatus status);
}
