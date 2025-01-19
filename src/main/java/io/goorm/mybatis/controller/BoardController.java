package io.goorm.mybatis.controller;

import io.goorm.mybatis.board.Board;
import io.goorm.mybatis.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /* 상세보기 */
    @GetMapping("/boards/{seq}")
    public String get(@PathVariable Long seq, Model model) {
        model.addAttribute("post",boardService.getBoardById(seq));

        return "/view";
    }

    /* 수정 */
    @GetMapping("/boards/update/{seq}")
    public String update(@PathVariable Long seq, Model model) {
        // 데이터베이스에서 Board 객체 조회
        Board board = boardService.getBoardById(seq);
        model.addAttribute("post", board); // "board"라는 이름으로 모델에 추가
        return "/edit"; // edit.html로 전달
    }

//    @PostMapping("/update")
//    public String updateBoard(@ModelAttribute Board board, Model model) {
//        boardService.updateBoard(board);
//        model.addAttribute("updatePost(1)",board);
//        return "redirect:/board/boards";
//    }


    /* 등록 */
    @GetMapping("/boards/create")
    public String createForm() {
        return "/create";
    }
}
