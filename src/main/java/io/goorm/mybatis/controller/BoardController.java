package io.goorm.mybatis.controller;

import io.goorm.mybatis.board.Board;
import io.goorm.mybatis.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    private static final Logger log = LogManager.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public String index() {
        return "board/index"; // 뷰 템플릿 경로를 반환
    }

    /* 리스트 */
    @GetMapping("/boards")
    public String list(Model model) {
        List<Board> list = boardService.getBoards();
        model.addAttribute("posts", list); // 데이터를 뷰로 전달
        return "/list"; // 뷰 템플릿 경로 반환
    }

    /* 등록 */
    @GetMapping("/boards/create")
    public String createForm() {
        return "/create";
    }
}
