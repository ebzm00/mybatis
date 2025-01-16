package io.goorm.mybatis.controller;

import io.goorm.mybatis.board.Board;
import io.goorm.mybatis.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardRestController {

    private static final Logger log = LogManager.getLogger(BoardRestController.class);
    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public String index() {

        return "api index";
    }

    /* 리스트 */
    @GetMapping("/boards")
    public List<Board> list() {
        List<Board> list = boardService.getBoards();
        log.debug("list size : {}", list.size());
        log.debug("test ");
        return list;
    }
}
