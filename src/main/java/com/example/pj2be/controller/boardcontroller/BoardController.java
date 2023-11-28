package com.example.pj2be.controller.boardcontroller;

import com.example.pj2be.domain.BoardDTO;
import com.example.pj2be.service.boardservice.BoardService;
import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

     // 게시글 작성
    @PostMapping("add")
    public void add(BoardDTO board,
                    @RequestParam(value = "files[]", required = false) MultipartFile[] files) throws Exception {

        boardService.save(board, files);
    }

    // 게시글 목록
    @GetMapping("list")
    public Map<String, Object> list() {
        return boardService.list();
    }

    // 게시글 보기
    @Transactional
    @GetMapping("id/{id}")
    public BoardDTO view(@PathVariable Integer id) {
        // 게시글 조회수 증가
        boardService.increaseViewCount(id);

        return boardService.get(id);
    }

    // 게시글 수정
    @PutMapping("edit")
    public void edit(@RequestBody BoardDTO board) {
        boardService.update(board);
    }

    // 게시글 삭제 (Update 형식)
    @PutMapping("remove/{id}")
    public void remove(@PathVariable Integer id) {
        boardService.remove(id);
    }

}
