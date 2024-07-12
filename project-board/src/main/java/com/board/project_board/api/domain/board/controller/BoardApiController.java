package com.board.project_board.api.domain.board.controller;

import com.board.project_board.api.domain.board.business.BoardBusiness;
import com.board.project_board.api.domain.board.controller.model.BoardRegisterRequest;
import com.board.project_board.api.domain.board.controller.model.BoardResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardBusiness boardBusiness;

    @PostMapping("/register")
    public ResponseEntity<BoardResponse> register(
            @Valid
            @RequestBody BoardRegisterRequest request
    ){
        var response = boardBusiness.register(request);

        return ResponseEntity.status(200)
                .body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<BoardResponse> search(

            @RequestParam(name="id") Long id
    ){
        var response = boardBusiness.search(id);

        return ResponseEntity.status(200)
                .body(response);
    }
}
