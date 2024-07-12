package com.board.project_board.db.post;

import com.board.project_board.db.post.enums.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity,Long> {


    //Board Id 를 받으면 모든 post 내용들을 보여주게 해주세요
    // select * from post where board_id = ? and status = ? order by id desc
    List<PostEntity> findAllByBoardIdAndStatusOrderByIdDesc(Long boardId, PostStatus status);

    //자신의 글이 선택되어 postid 가 오면 자신의 정보 보여주기
    //select * from post where board_id = ? and id = ? status = ? limit 1
    Optional<PostEntity> findFirstByIdAndStatus( Long id , PostStatus status);



}
