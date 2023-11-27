package com.example.pj2be.controller.commentcontroller;

import com.example.pj2be.domain.comment.CommentDTO;
import com.example.pj2be.service.commentservice.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService service;

    @PostMapping("/add")
    public void commentAdd(@RequestBody CommentDTO comment) {
        service.add(comment);
    }
}
