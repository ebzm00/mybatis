package io.goorm.mybatis.ajaxController;

import io.goorm.mybatis.board.Board;
import io.goorm.mybatis.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/ajax")
public class AjaxBoardController {

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
        return "/list";

    }
}
